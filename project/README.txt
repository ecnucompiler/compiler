/************/
** 总体概况 **
/************/
parser&lexer: 词法语法分析器
vim hignlight for bp file: 改语法vim下的高亮插件 配置过程见文件夹内的README.txt

/**************************/
** parser&lexer下文件明细 **
/**************************/

.bp文件的词法语法分析器

Makefile: make指令输出一个文件parser, make clean清除所有编译产生的文件

proj.l: lex词法分析器

proj.y: yacc语法分析器

symtab.h symtab.cc: 储存id表的数据结构，内部使用STL map实现

error.h error.cc: 错误处理的函数

test: 一些测试用的文件，.bp结尾，详见测试文件内注释
