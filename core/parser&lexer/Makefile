parser: lex.yy.c y.tab.c symtab.o error.o
	g++ -w y.tab.c lex.yy.c symtab.o error.o -ll -ly -o $@	

symtab.o: symtab.cc symtab.h 
	g++ -w -c symtab.cc -o $@

error.o: error.cc error.h
	g++ -w -c error.cc -o $@
	
lex.yy.c: proj.l
	lex  proj.l

y.tab.c: proj.y symtab.h util.h
	yacc proj.y --defines

clean:
	rm symtab.o
	rm lex.yy.c
	rm y.tab.c
	rm y.tab.h
	rm parser
	rm error.o
