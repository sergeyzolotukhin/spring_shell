package ua.in.sz.shell.shell.command;

import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class UserCommand {

	private final LineReader lineReader;
	private final Terminal terminal;

	@Lazy
	public UserCommand(LineReader lineReader, Terminal terminal) {
		this.lineReader = lineReader;
		this.terminal = terminal;
	}

	@ShellMethod("Add user.")
	public String add() {
		print(red("Hi"));

		String name = lineReader.readLine(red(String.format("name [%s]:", "root")));
		String password = lineReader.readLine(String.format("password [%s]:", "root"));

		return String.format("create user [%s/%s]", name, password);
	}

	private String red(String message) {
		AttributedStringBuilder attr = new AttributedStringBuilder();
		AttributedStyle fg = AttributedStyle.DEFAULT.foreground(AttributedStyle.RED);

		return attr.append(message, fg).toAnsi();
	}

	private void print(String text) {
		terminal.writer().println(text);
		terminal.flush();
	}
}
