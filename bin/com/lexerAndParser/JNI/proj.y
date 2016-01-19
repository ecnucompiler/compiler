/*
 * 语法分析器for bp file
 * @author: ned_chu
 */

%{

#include "util.h"
#include "symtab.h"
#include "error.h"


// 符号表的实体 @see: symtab.h
Symtab symtab;

// 词法分析
int yylex();

// 尝试增加一个类型为type名称为id的条目
void addId(const char *id, const ID_TYPE type);

// 当前分析的词法
extern char *yytext;

%}

/* 需要的词素，由lexer返回 */
%token ID
%token CONST STAR
%token GLOBAL LOCAL DEFINE
%token BIOP

/* 需要的运算符 */
%left BIOP
%nonassoc UMINUS

%%

trpds: macroDefList finishMacro
     | finishMacro
     ;

finishMacro: varDecl finishVar
           | finishVar
           ;

finishVar: initConfig ruleList
         | initConfig
         ;





stackid: ID { addId(yytext, TYPE_STACK_ID); }
       ; 

ctrlid: ID { addId(yytext, TYPE_CTRL_ID); } 
  ;

id: ID { addId(yytext, TYPE_ID); }
  | error { yyerror("expecting valid id"); }
  ;


LRB: '('
   ;

RRB: ')' 
   | error { yymaerror(')'); }
   ;

LTB: '<'
   | error { yymaerror('<'); }
   ;

RTB: '>'
   | error { yymaerror('>'); }
   ;

TO : '-'
   | error { yymaerror('-'); }
   ;

ST: '\"'
   | error { yymaerror('\"'); }
  ;




macroDefList: macroDefList macroDef
            | macroDef
            ;

macroDef: DEFINE id expr

        | error { yyerror("expecting valid macro define"); }
        ;

expr: expr BIOP expr
    | '!' expr %prec UMINUS
    | LRB expr RRB 
    | CONST
    | STAR
    
    | error { yyerror("expecting valid expression"); yyclearin; }
    ;




varDecl: globalDecl localDeclList
       | globalDecl
       | localDeclList
       ;

globalDecl: GLOBAL globalVarList 
          | GLOBAL
          ;

globalVarList: globalVarList id
             | id
             ;


localDeclList: localDeclList localDecl
             | localDecl
             ;

localDecl: localBody localVarList
         | localBody
         ;

localBody: LOCAL stackid

         | LOCAL error { yyerror("expecting valid stack id"); yyclearin; }
         ;

localVarList: localVarList id
            | id
            ;




initConfig: LRB ctrlid stackConfig RRB
          ;

stackConfig: LTB stackid RTB
           ;




ruleList: ruleList rule
        | rule
        ;

rule: explicitPart optionalPart
    | explicitPart
    ;

explicitPart: exLeft exMid exRight
            ;

exLeft: ctrlid LTB stackid RTB
      
      | ctrlid LTB error { yyerror("expecting stack id"); }
      ;

exMid: TO TO RTB
     ;

exRight: ctrlid LTB RTB
       | ctrlid LTB stackList RTB 
       
       | error { yyerror("expecting valid ctrl id"); } 
       ;

stackList: stackid
         | stackid stackid
         ;

optionalPart: optLabel optTr
            | optLabel
            | optTr
            ;

optLabel: ST id ST
        ;

optTr: LRB id RRB
     ;

%%

void addId(const char *s, const ID_TYPE type) {
  // id两个不能相同，其他其他可以相同，冲突输出错误
  if (!symtab.isInTable(s)) {
    symtab.insertSym(s, type);
  } else if (!symtab.insertSym(s, type)) {
    yyiderror(s, symtab.getSymType(s), type);
  } else if (type == TYPE_ID) {
    yyiderror(s);
  }
}

int main() {
  if (yyparse() == 0) {
    puts("successful parsing!");
  }
  return 0;
}
