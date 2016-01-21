# compiler
组员：储德明　陈锴　吴炎　郑寒月　袁嘉麟　安东　李娅
项目难度　80分
文件说明
运行环境: Linux
命令行版本实现语言：C++, C，有高亮
Java版本实现语言：C++,c ,java,JNI连接，有界面

可能需要的额外需求：手动添加compiler/src/com/lexerAndParser/JNI/libgoodlucky.so　　这个库文件到系统可以找到的系统目录下，
或者在eclipse或其他IDE下右键项目，选择导入本地库文件

亮点说明：包含了我们组项目的亮点
Document: 组员的个人完成情况说明
core ：核心的C代码,实现了scan和parse
bin :java代码生成的类文件
src/com/lexerAndParser：　UI界面部分
　　　CodeEditor　：UI编辑窗口
　　　JNI :java 和Ｃ连接的部分
　　　UI　:UI界面
      FileHelper.java：读取文件相关
      Main.java：项目入口
