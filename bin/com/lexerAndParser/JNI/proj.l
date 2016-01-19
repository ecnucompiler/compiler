/**
 * 词法分析器for bp file
 * @author: ned_chu
 */

%option yylineno
%{

#include "util.h"
#include "y.tab.h"
#include "error.h"

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
  return CONST;
}

{biop} {
  //二元运算符
  updateCol();
  return BIOP;
}

{star} {
  // 小星星
  updateCol();
  return STAR;
}

{global} {
  //全局声明符
  updateCol();
  return GLOBAL;
}

{local} {
  //局部声明符
  updateCol();
  return LOCAL;
}

{define} {
  //宏定义符
  updateCol();
  return DEFINE;
}

{id} {
  //标识符
  updateCol();
  return ID;
}

{op} {
  // 使用的符号
  updateCol();
  return yytext[0];
}

"/*" {
  // 块注释的错误
  yyerror("expecting block comment: \'*/\'");
  updateCol();
}

"*/" {
  // 块注释的错误
  yyerror("expecting block commnet: \'/*\'");
  updateCol();
}

\/ {
  // 行注释的错误
  yyerror("expecting line comment: \'//\'");
}

{rest} {
  //其他
  updateCol();
  yyrcerror(yytext[0]);
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
