package com.littlefishlabs.intellij;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by PamelaPeixinho on 19/03/17.
 * This simple plugin was created following this tutorial:
 * See <a href="https://www.cqse.eu/en/blog/intellij-plugin-tutorial/">intellij-plugin-tutorial</a>
 */

public class SimpleStartupActivity implements StartupActivity {

	@Override
	public void runActivity(@NotNull Project project) {
		// This code is executed after the project was opened.
		System.out.println("Hello World Little Fish! Loaded project: " + project.getName());
	}
}
