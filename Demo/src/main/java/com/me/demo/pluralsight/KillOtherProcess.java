package com.me.demo.pluralsight;

public class KillOtherProcess {

    public static void main(String[] args) {
        ProcessHandle textEditHandle = ProcessHandle.allProcesses()
                .filter(h -> h.info().commandLine().map(cmd -> cmd.contains("notepad")).orElse(false))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No matching handle found"));

        System.out.println(textEditHandle.info());

        textEditHandle.onExit()
        .thenAccept(h -> System.out.println("TextEdit was killed by Java"));

        boolean shutdown = textEditHandle.destroy();

        textEditHandle.onExit().join();

        System.out.println("Shutdown: " + shutdown);
    }
}
