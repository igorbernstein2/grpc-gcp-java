package io.grpc.gcs;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class Args {
  private static final String DEFAULT_HOST = "storage.googleapis.com";
  private static final int PORT = 443;

  final int calls;
  final String cookie;
  final String host;
  final int port;
  final String bkt, obj;
  final boolean http, dp;
  final int size;
  final String method;

  Args(String[] args) throws ArgumentParserException {
    ArgumentParser parser =
        ArgumentParsers.newFor("GCS client test")
            .build()
            .defaultHelp(true)
            .description("GCS client java binary");

    parser.addArgument("--calls").type(Integer.class).setDefault(1);
    parser.addArgument("--cookie").type(String.class).setDefault("");
    parser.addArgument("--host").type(String.class).setDefault(DEFAULT_HOST);
    parser.addArgument("--port").type(Integer.class).setDefault(PORT);
    parser.addArgument("--bkt").type(String.class).setDefault("gcs-grpc-team-weiranf");
    parser.addArgument("--obj").type(String.class).setDefault("a");
    parser.addArgument("--http").type(Boolean.class).setDefault(false);
    parser.addArgument("--dp").type(Boolean.class).setDefault(false);
    parser.addArgument("--size").type(Integer.class).setDefault(0);
    parser.addArgument("--method").type(String.class).setDefault("media");

    Namespace ns = parser.parseArgs(args);

    // Read args
    calls = ns.getInt("calls");
    cookie = ns.getString("cookie");
    host = ns.getString("host");
    port = ns.getInt("port");
    bkt = ns.getString("bkt");
    obj = ns.getString("obj");
    http = ns.getBoolean("http");
    dp = ns.getBoolean("dp");
    size = ns.getInt("size");
    method = ns.getString("method");
  }
}
