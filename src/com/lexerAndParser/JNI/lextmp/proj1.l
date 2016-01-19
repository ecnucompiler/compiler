/**
 * 词法分析器for bp file
 * @author: ned_chu
 */
%option yylineno
%option noyywrap
%{

// @see: util.h
int yycolno = 0;


/**
 * 根据yytext中的内容更新列号和非SP长度
 * @postcond: 列号更新为正确的数目
 */
void updateCol();

%}

sp [ \t\n]+

id [a-zA-Z_][a-zA-Z0-9_]*
const [0,1]
biop [\&^=|]|"!="|"=>"
star \*
op [-<>!()"]

blockComm "/*"([^*]|(\*)*[^*/])*(\*)*"*/"
lineComm "//"[^\n]*

global global
local local
define define

rest .

%%

{sp} {
  // 空格或者回车或者制表符
  updateCol();
}

{blockComm}|{lineComm} {
  // 块注释&行注释
  updateCol();
}

{const} {
  //常量
  updateCol();
  printf("<const,%s>\n", yytext);
}

{biop} {
  //二元运算符
  updateCol();
  printf("<biop,%s>\n", yytext);
}

{star} {
  // 小星星
  updateCol();
  printf("<star,%s>\n", yytext);
}

{global} {
  //全局声明符
  updateCol();
  printf("<global>\n");
}

{local} {
  //局部声明符
  updateCol();
  printf("<local>\n");
}

{define} {
  //宏定义符
  updateCol();
  printf("<define>\n");
}

{id} {
  //标识符
  updateCol();
  printf("<id,%s>\n", yytext);
}

{op} {
  // 使用的符号
  updateCol();
  printf("<op,%s>\n", yytext);
}



{rest} {
  //其他
  updateCol();
}

%%
void updateCol() {
  for (int i = 0; i < yyleng; i++) {
    if (yytext[i] == '\n') {
      yycolno = 0;
    } else {
      yycolno++;
    }
  }
}

int main(){
   yyin = stdin;
   return yylex();
}
