package intercept;

import intercept.configuration.InterceptConfiguration;
import intercept.logging.ConsoleApplicationLog;
import intercept.server.InterceptServer;

public class Application {
    public void run(String args[]) {
        ConsoleApplicationLog logger = new ConsoleApplicationLog();
        InterceptConfiguration configuration = new InterceptConfiguration(logger, args);
        InterceptServer server = new InterceptServer(logger);

        if (configuration.getCommand() == null) {
            System.err.println("Configuration error: Please specify start or stop command");
            return;
        }

        switch (configuration.getCommand()) {
            case start:
                server.start(configuration);
                break;
            case stop:
                server.stop(configuration);
                break;
        }
    }
}
