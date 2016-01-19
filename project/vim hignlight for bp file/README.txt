/**************************/
** .bp文件vim高亮安装说明 **
/**************************/

需要安装VIM

需要找到VIM运行加载的路径，定义为$VIM_RUN
Unix/Linux下为~/.vim

在路径$VIM_RUN/filetype.vim中在末尾加入语句
au BufRead,BufNewFile *.bp setfiletype bpp

在$VIM_RUN/syntax中移入bpp.vim

配置后*.bp形式的文件会被按照语言的定义进行高亮
