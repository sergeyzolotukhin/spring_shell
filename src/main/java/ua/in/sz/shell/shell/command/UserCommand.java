package ua.in.sz.shell.shell.command;

import org.jline.reader.LineReader;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class UserCommand {

	private final LineReader lineReader;

	@Lazy
	public UserCommand(LineReader lineReader) {
		this.lineReader = lineReader;
	}

	@ShellMethod("Add user.")
	public String add() {
		String name = lineReader.readLine(String.format("name [%s]:", "root"));
		String password = lineReader.readLine(String.format("password [%s]:", "root"));

		return String.format("create user [%s/%s]", name, password);
	}
}
