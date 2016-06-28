package com.github.okbuilds.okbuck.rule

final class GenSqlDelightRule extends BuckRule {

    private final String mSqlDelightRunnerPath
    private final String mOutputDir

    GenSqlDelightRule(String name, String sqlDelightRunnerPath, String outputDir) {
        super("gen", name)
        mSqlDelightRunnerPath = sqlDelightRunnerPath
        mOutputDir = outputDir
    }

    @Override
    final void print(PrintStream printer) {
        printer.println("genrule(")
        printer.println("\tname = '${name}',")
        printer.println("\tsrcs = glob([")
        printer.println("\t\t'src/*/sqldelight/**/*.sq',")
        printer.println("\t]),")
        printer.println("\tout = 'out',")
        printer.println("\tbash = 'java -jar ${mSqlDelightRunnerPath} \$SRCDIR ${mOutputDir} && echo \$SRCS > \$OUT',")
        printer.println(")")
        printer.println()
    }

    @Override
    protected void printContent(PrintStream printer) {
    }
}
