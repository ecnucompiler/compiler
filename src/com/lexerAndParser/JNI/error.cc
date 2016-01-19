/**
 * 错误处理函数的实现
 * @author: ned_chu
 * @see: error.h
 */

#include "util.h"
#include "error.h"

// print line column position of error
void printPos(const char *s) {
  printf("error: %d:%d %s", yylineno, yycolno, s);
}

// normal error
void yyerror(const char *s) {
  printPos(s);
  puts(".");
}


// id error
void yyiderror(const char *id) {
  printPos("redefination");
  printf(": \'%s\'.\n", id);
}


// ID_TYPE对应的字符串
char typeStr[5][25] = {"id", "ctrl id", "stack id"};

void yyiderror(const char *id, const ID_TYPE symtype, const ID_TYPE type) {
  printPos("conflict: ");
  printf("\'%s\' is \'%s\', can't be used as \'%s\'.\n", id, typeStr[symtype], typeStr[type]);
}


// recognize error
void yyrcerror(const char ch) {
  printPos("can't recognize: ");
  printf("\'%c\'.\n", ch);
}

// match error
void yymaerror(const char ch) {
  printPos("character missing: ");
  printf("expecting \'%c\'.\n", ch);
}
