#include <stdio.h>
#include<string.h>
#include<stdlib.h>
#include<iostream>
#include<fstream>
#include<string>
#include "com_lexerAndParser_JNI_TestJNI.h"
#include<unistd.h>
using namespace std;
        int myx=0;

        JNIEXPORT void JNICALL Java_com_lexerAndParser_JNI_TestJNI_set
          (JNIEnv *env, jobject job, jint j)
        {  
               myx=j;

            }
        JNIEXPORT jint JNICALL Java_com_lexerAndParser_JNI_TestJNI_get
          (JNIEnv *env, jobject job)
        {  
                 return myx+1;
               }
        int testJNI(int);
        char* jstringTostring(JNIEnv* env, jstring jstr);
        jstring stoJstring(JNIEnv* env, const char* pat);



        /*
         * Class:     com_lexerAndParser_JNI_TestJNI
         * Method:    scan   扫描词素
         * Signature: (Ljava/lang/String;)Ljava/lang/String;
         */
        JNIEXPORT jstring JNICALL Java_com_lexerAndParser_JNI_TestJNI_parse
                 (JNIEnv *env, jobject job, jstring jstr){
               	char *str = jstringTostring(env,jstr);
               	        //		string ss = string(str);
               	//在这里ss和str均为输入的代码，现在要将调用yacc得到错误信息返回
               	char *locc= getcwd(NULL,0);
#ifdef linux
               	string loc=string(locc)+"/src/com/lexerAndParser/JNI/";
#endif
#ifdef _WIN32
               	string loc=string(locc)+"\src\com\lexerAndParser\JNI\";
#endif

               	string parse=loc+"parse";
               	string code=loc+"parse_in";
               	string result=loc+"parse_result";
               	string cmd=parse+" < "+code+" > "+result;
               	ofstream out(code.c_str());
               	     if (out.is_open())
               	    {
               	        out<<str;
              	     }
               	     out.close();


               	system(cmd.c_str());



               	ifstream in(result.c_str());
               	 istreambuf_iterator<char> beg(in), end;
               	 string strdata(beg, end);
               	 in.close();

               	 in.close();
               	strdata="parsing....\n"+strdata;

               	//const char * return1 = (const char*) str;
               	const char * return2 = (const char*) strdata.c_str();
               	return stoJstring(env,(const char*)return2 );
               }

        /*
         * Class:     com_lexerAndParser_JNI_TestJNI
         * Method:    parse　解析语法
         * Signature: (Ljava/lang/String;)Ljava/lang/String;
         */
        JNIEXPORT jstring JNICALL Java_com_lexerAndParser_JNI_TestJNI_scan
		(JNIEnv *env, jobject job, jstring jstr){
        	char *str = jstringTostring(env,jstr);
        //	string ss = string(str);
//在这里ss和str均为输入的代码，现在要将调用lex得到词素序列返回
         	char *locc= getcwd(NULL,0);
#ifdef linux
               	string loc=string(locc)+"/src/com/lexerAndParser/JNI/";
#endif
#ifdef _WIN32
               	string loc=string(locc)+"\src\com\lexerAndParser\JNI\";
#endif
                       	string scan=loc+"lex";
                       	string code=loc+"scan_in";
                       	string result=loc+"scan_result";
                       	string cmd=scan+" < "+code+" > "+result;
                       	ofstream out(code.c_str());
                       	     if (out.is_open())
                       	    {
                       	        out<<str;
                       	     }
                       	     out.close();


                       	system(cmd.c_str());



                       	ifstream in(result.c_str());
                       	 istreambuf_iterator<char> beg(in), end;
                       	 string strdata(beg, end);
                       	 in.close();

                       	 in.close();
                       	strdata="scanning....\n"+strdata;

                       	//const char * return1 = (const char*) str;
                       	const char * return2 = (const char*) strdata.c_str();
                       	return stoJstring(env,(const char*)return2 );

        }




        char* jstringTostring(JNIEnv* env, jstring jstr)
        {
               char* rtn = NULL;
               jclass clsstring = env->FindClass("java/lang/String");
               jstring strencode = env->NewStringUTF("utf-8");
               jmethodID mid = env->GetMethodID(clsstring, "getBytes", "(Ljava/lang/String;)[B");
               jbyteArray barr= (jbyteArray)env->CallObjectMethod(jstr, mid, strencode);
               jsize alen = env->GetArrayLength(barr);
               jbyte* ba = env->GetByteArrayElements(barr, JNI_FALSE);
               if (alen > 0)
               {
                         rtn = (char*)malloc(alen + 1);
                         memcpy(rtn, ba, alen);
                         rtn[alen] = 0;
               }
               env->ReleaseByteArrayElements(barr, ba, 0);
               return rtn;
        }

        //char* to jstring
        jstring stoJstring(JNIEnv* env, const char* pat)
        {
               jclass strClass = env->FindClass("Ljava/lang/String;");
               jmethodID ctorID = env->GetMethodID(strClass, "<init>", "([BLjava/lang/String;)V");
               jbyteArray bytes = env->NewByteArray(strlen(pat));
               env->SetByteArrayRegion(bytes, 0, strlen(pat), (jbyte*)pat);
               jstring encoding = env->NewStringUTF("utf-8");
               return (jstring)env->NewObject(strClass, ctorID, bytes, encoding);
        }

        //invoke function
        JNIEXPORT jstring JNICALL Java_test_cs_web_SWIFTAlianceCASmfTest_strcal
          (JNIEnv *env, jclass obj, jstring jstr1, jstring jstr2)
        {
            jbyteArray bytes = 0;
            jthrowable exc;
            char *pszResult = NULL;
            char *pszSTR1 = NULL;
            char *pszSTR2 = NULL;

            pszSTR1 = jstringTostring(env, jstr1);
            pszSTR2 = jstringTostring(env, jstr2);

            int nlen = sizeof(char)*(strlen(pszSTR1)+strlen(pszSTR2));
            pszResult = (char*)malloc(nlen);
            strcpy(pszResult, pszSTR1);
            strcat(pszResult, pszSTR2);

            jstring jstrRe = stoJstring(env, pszResult);
            free(pszSTR1);
            free(pszSTR2);
            free(pszResult);
            return(jstrRe);
        }
        /*
         * input code and return error string
         * */
        /*
        JNIEXPORT jstring JNICALL Java_TestJNI_compile
          (JNIEnv *env, jobject obj, jstring jstr)
        {
        	//const char *str=jstringTostring(env,jstr);
        	//return CharTojstring(&env, "hahaha");
        	jstring str=CharTojstring(env, "hahaha");
        	return str;

        }*/

