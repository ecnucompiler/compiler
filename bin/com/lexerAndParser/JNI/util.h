#ifndef UTIL_H_INCLUDED
#define UTIL_H_INCLUDED

/**
 * 项目使用的头文件，变量及函数
 * @author: ned_chu
 */

// 头文件
#include <cstdio>
#include <map>
#include <string>

using namespace std;


// 标识符类型的枚举类型
enum ID_TYPE {
  TYPE_ID = 0, TYPE_CTRL_ID = 1, TYPE_STACK_ID = 2, TYPE_NOT_IN = 3
};

// 行号
extern int yylineno;
// 当前列号
extern int yycolno;

#endif // UTIL_H_INCLUDED
