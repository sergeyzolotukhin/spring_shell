package ua.in.sz.shell.shell;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class ShellApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ShellApplication.class);
		app.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
				printStream.println(AnsiOutput.toString(AnsiColor.GREEN, "tools", AnsiColor.DEFAULT, " ", AnsiStyle.FAINT, "1.0"));
				printStream.println();
			}
		});
		app.run(args);
	}

}
