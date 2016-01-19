#ifndef ERROR_H_INCLUDED
#define ERROR_H_INCLUDED

#include "util.h"

/**
 * 错误处理的函数
 * @author: ned_chu
 */

// 打印错误头及位置信息
void printPos(const char *s);

// 普通错误及警告
void yyerror(const char *s);

// id重定义错误
void yyiderror(const char *id);
// id冲突错误
void yyiderror(const char *id, const ID_TYPE symtype, const ID_TYPE type);

// 无法识别的字符
void yyrcerror(const char ch);

// 不匹配
void yymaerror(const char ch);

#endif // ERROR_H_INCLUDED
