import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.lang.ASTNode;
import com.intellij.lang.FileASTNode;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiLocalVariable;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.tree.xml.IDTDElementType;
import com.sun.tools.internal.ws.processor.model.java.JavaType;
import com.sun.tools.javac.model.JavacTypes;
import myToolWindow.SimpleToolWindowFactory;


/**
 * Created by PamelaPeixinho on 19/03/17.
 * This simple plugin (with actions) was created following this tutorial:
 * See <a href="http://bjorn.tipling.com/how-to-make-an-intellij-idea-plugin-in-30-minutes">intellij-plugin-tutorial</a>
 */
public class ReadCurrentFile extends AnAction {

	@Override
	public void actionPerformed(AnActionEvent e) {

		final Project project = e.getProject();



		String txt = Messages.showInputDialog(project, "What is your Doubt?", "Input Your Query", Messages.getQuestionIcon());
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
//---------TESTING extract PSI
//		PsiFile teste = e.getData(LangDataKeys.PSI_FILE);
		PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);

		assert psiFile != null;
		System.out.println(psiFile.getLanguage());
		System.out.println(psiFile.getFileType());
		FileASTNode astFileNodes = psiFile.getNode();
		ASTNode node = astFileNodes.getFirstChildNode().getTreeNext();
		System.out.println(node);
//---------------------------
//		JavaFileType.INSTANCE;

		String currentText = document.getText();
		System.out.print(currentText);


	}
}
