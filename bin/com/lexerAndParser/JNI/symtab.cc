#include"symtab.h"

/**
 * symtab.h中Symtabl的实现
 * @author: ck
 * @modify: ned_chu
 * @see: symtab.h
 */

bool Symtab::insertSym(const string &s, const ID_TYPE type) {
  map<string, ID_TYPE>::iterator it = table.find(s);
  if (it == table.end()) {
		table[ s ] = type;
		return true;
	} else {
		return it->second == type;
	}
}

bool Symtab::insertSym(const char *s, const ID_TYPE type) {
	string str(s);
	return insertSym(str, type);
}

bool Symtab::isInTable(const string &s) const {
	return table.find(s) != table.end();
}


bool Symtab::isInTable(const char *s) const {
	string str(s);
	return isInTable(str);
}


ID_TYPE Symtab::getSymType(const string &s) {
	map<string, ID_TYPE>::iterator it = table.find(s);
  if (it == table.end()) return TYPE_NOT_IN;
	else return it->second;
}


ID_TYPE Symtab::getSymType(const char *s) {
	string str(s);
	return getSymType(str);
}

void Symtab::removeSym(const string &s) {
	map<string, ID_TYPE>::iterator it = table.find(s);
  if (it != table.end()) {
		table.erase(it);
	}	
}

void Symtab::removeSym(const char *s) {
	string str(s);	
	removeSym(str);
}

void Symtab::clear(){
	table.clear();
}
