#ifndef SYMTAB_H_INCLUDED
#define SYMTAB_H_INCLUDED

/**
 *  @author: ned_chu
 *  @modify: ned_chu, ck
 *  符号表的类，内部使用map来实现，对于id ctrlid stackid分别进行储存
 */
#include "util.h"

// 符号表的类
class Symtab {
public:
  /**
   * 插入一个标识符
   * @precond: s对应了合法的标识符，详见语言对于id的定义
   * @postcond: 如果table中没有s插入s入table，对应了type，否则不插入
   * @return: 如果表中没有s或者表中s的类型与type一致返回true，否则返回false
   */
  bool insertSym(const char *s, const ID_TYPE type);
  bool insertSym(const string &s, const ID_TYPE type);
  
  /**
   * 判断标识符是否在表内
   * @precond: s对应了合法的标识符，详见语言对于id的定义
   * @return: 如果s在表中返回true，否则返回false
   */
  bool isInTable(const char *s) const;
  bool isInTable(const string &s) const;

  /**
   * 获得标识符的类型
   * @precond: s对应了合法的标识符，详见语言对于id的定义
   * @return: 如果s不在表中返回ID_TYPE.notin，否则返回结果
   */
  ID_TYPE getSymType(const char *s);
  ID_TYPE getSymType(const string &s);

  /**
   * 移除标识符
   * @precond: s对应了合法的标识符，详见语言对于id的定义
   * @postcond: 如果table中没有s则不变，如果有s该标识符被删除
   */
  void removeSym(const char *s);
  void removeSym(const string &s);
  
  /**
   * 清空整个表
   * @postcond: table被清空
   */
  void clear();

private:
  // 储存符号的数据结构，标识符映射到对应的类型
  map<string, ID_TYPE> table;
};



#endif // SYMTAB_H_INCLUDED
