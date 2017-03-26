import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
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
		// TODO: insert action logic here

		final Project project = e.getProject();

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

//		get the (virtual)file of document
		VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(document);
		if (virtualFile == null) {
			return;
		}

		final String contents;
		try {
//			put on buffer to read the file
			BufferedReader br = new BufferedReader(new FileReader(virtualFile.getPath()));
			String currentLine;
			StringBuilder stringBuilder = new StringBuilder();
			while ((currentLine = br.readLine()) != null) {
				stringBuilder.append(currentLine);
				stringBuilder.append("\n");
			}
			contents = stringBuilder.toString();
		} catch (IOException e1) {
			return;
		}

//		in other thread set text to the document with the contents that came from that virtual file
		final Runnable readRunner = new Runnable() {
			@Override
			public void run() {
				document.setText(contents);
			}
		};

		ApplicationManager.getApplication().invokeLater(new Runnable() {

			@Override
			public void run() {
				CommandProcessor.getInstance().executeCommand(project, new Runnable() {

					@Override
					public void run() {
						ApplicationManager.getApplication().runWriteAction(readRunner);
					}

				}, "DiskRead", null);
			}
		});
	}
}
