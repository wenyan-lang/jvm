package cn.wenyan.compiler;


import cn.wenyan.compiler.command.CommandHandler;
import cn.wenyan.compiler.script.libs.Language;


public class Main {

    public static void main(String[] args){
        if(args.length == 1 && args[0].equals("shell")){
            WenYanShell.run();
            return;
        }
        if (args.length == 0){
            CommandHandler.compileCommand.entrySet().stream().forEach(x->System.out.println(x.getValue().getOption()+": "+x.getValue().getClass().getSimpleName()));
        }
        WenYanCompiler compiler = new WenYanCompilerImpl(false, Language.GROOVY);

        compiler.compile(args);

        System.out.println(compiler.dispatch("吾有一元。曰三。名之曰「曼德博」。"));
    }
}
