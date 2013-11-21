package seeko.cli;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aceyin on 13-11-21.
 */
public class Main {

    @Option(name = "-h", usage = "print help message")
    private String help;

    @Argument
    private List<String> arguments = new ArrayList<String>();

    public static void main(String... args) {
        System.out.printf("%80s", "Welcome to Seeko");
        Main main = new Main();
        main.exec(args);
    }

    private void exec(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        parser.setUsageWidth(80);

        try {
            parser.parseArgument(args);
            if (arguments.isEmpty()) {
                throw new CmdLineException(parser, "No arguments");
            }


        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("seeko.sh [options...] arguments...");
            // print the list of available options
            parser.printUsage(System.err);
            System.err.println();

            return;
        }
    }

    private void printUsage() {
        System.out.println("Usage: seeko.sh <install|start|stop>");
    }
}
