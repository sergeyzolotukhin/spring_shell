package ua.in.sz.shell.shell.command;

import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class MyCommands {

	@ShellMethod("Add two integers together.")
	public int add(int a, int b) {
		return a + b;
	}
}
