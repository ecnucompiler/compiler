JAVA=/home/chenkai/Desktop/jdk1.8.0_60
ProDir=/home/chenkai/workspace/CompileProject
libgoodlucky.so:makefile TestJNI.o lex.yy.o y.tab.o symtab.o error.o parse
	g++ -w  -fPIC -rdynamic -shared -o libgoodlucky.so TestJNI.o  y.tab.o lex.yy.o symtab.o error.o -ll -ly
	
TestJNI.o:TestJNI.c com_lexerAndParser_JNI_TestJNI.h  
	g++ -w -Wall -fPIC -c TestJNI.c -I./ -I $(JAVA)/include -I $(JAVA)/include/linux

com_lexerAndParser_JNI_TestJNI.h :TestJNI.class 
	javah -classpath  $(ProDir)/src -jni  com.lexerAndParser.JNI.TestJNI
	
TestJNI.class:TestJNI.java
	javac TestJNI.java

parse:lex.yy.o y.tab.o symtab.o error.o
	g++ -w  -fPIC -o $@  y.tab.o lex.yy.o symtab.o error.o  -ll -ly

symtab.o: symtab.cc symtab.h 
	g++ -w -fPIC -c symtab.cc -o $@

error.o: error.cc error.h
	g++ -w -fPIC -c error.cc -o $@
	
lex.yy.o:lex.yy.c y.tab.o
	g++ -w -fPIC -c lex.yy.c -o $@
	
y.tab.o:y.tab.c
	g++ -fPIC -w -c y.tab.c -o $@
lex.yy.c:proj.l
	lex   proj.l

y.tab.c: proj.y symtab.h util.h
	yacc proj.y --defines

clean:
	rm lex.yy.c
	rm y.tab.c
	rm y.tab.h
	rm  *.o 
	rm *.so 
	rm *.class 
	rm com_lexerAndParser_JNI_TestJNI.h 
	rm parser
	