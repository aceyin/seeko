package seeko.cli;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

/**
 * Created by aceyin on 13-11-21.
 */
public class UsageHandler extends OptionHandler {

    protected UsageHandler(CmdLineParser parser, OptionDef option, Setter setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters parameters) throws CmdLineException {
        return 0;
    }

    @Override
    public String getDefaultMetaVariable() {
        return null;
    }
}
