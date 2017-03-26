import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.*;

/**
 * Created by PamelaPeixinho on 19/03/17.
 * This simple plugin (with actions) was created following this tutorial:
 * See <a href="http://bjorn.tipling.com/how-to-make-an-intellij-idea-plugin-in-30-minutes">intellij-plugin-tutorial</a>
 */
public class ReadCurrentFile extends AnAction {

	@Override
	public void actionPerformed(AnActionEvent e) {

		final Project project = e.getProject();

		String txt= Messages.showInputDialog(project, "What is your Doubt?", "Input your query", Messages.getQuestionIcon());
//		Messages.showMessageDialog(project, "Hello, " + txt + "!\n I am glad to see you.", "Information", Messages.getInformationIcon());

		if (project == null) {
			return;
		}

		System.out.println("Project name " + project.getName());
		System.out.println("Project filepath " + project.getProjectFilePath());

//		get the current text editor of the project
		Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
		if (editor == null) {
			return;
		}

//		get the document of editor
		final Document document = editor.getDocument();
		if (document == null) {
			return;
		}

		String currentText = document.getText();
		System.out.print(currentText);
	}
}
