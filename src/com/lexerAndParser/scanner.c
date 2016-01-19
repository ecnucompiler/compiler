/* ***********************************************
Author        :ck
Created Time  :2016年01月10日 星期日 16时01分14秒
File Name     :scanner.c
************************************************ */

#include <stdio.h>
#include <string.h>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <set>
#include <map>
#include <string>
#include <math.h>
#include <stdlib.h>
#include <time.h>
using namespace std;
const int N=105;
const int M=1005;
char name[N];
char re[N];
int id;
struct Edge{
	int to,nxt;
	char val[N];
}edge[M];

int head[N];
int tot;
void addEdge(int u,int v,char *var){
	edge[tot].to=v;
	strcpy(edge[tot].val,var);	
	edge[tot].nxt=head[u];
	head[u]=tot++;
}

int list_cnt;
struct NodeList{
	int start,end;
}list[N]; 

void init(){
	memset(head,-1,sizeof head);
	tot=0;
	list_cnt=0;
	id=0;
}
int getId(){
	return id++;
}
int main()
{
    freopen("toekn_rule","r",stdin);
    //freopen("out.txt","w",stdout);
	init();
	int start,end;
	start=getId();
	end=getId();
	while(scanf("%s",name)==1){
		scanf("%s",re);	

	
	}


    
    return 0;
}
