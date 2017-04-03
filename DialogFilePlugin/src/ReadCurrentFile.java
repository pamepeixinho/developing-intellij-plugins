import com.intellij.lang.ASTNode;
import com.intellij.lang.FileASTNode;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiPackage;
import com.intellij.psi.search.searches.ReferencesSearch;
import java.util.Arrays;


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
		System.out.print(Arrays.toString(psiFile.getParent().getVirtualFile().getBOM()));
		System.out.print(psiFile.getParent().getVirtualFile().getCanonicalFile().getCharset());

		assert psiFile != null;

		System.out.println(psiFile.getLanguage());
		System.out.println(psiFile.getFileType());
		FileASTNode astFileNodes = psiFile.getNode();
		ASTNode node = astFileNodes.getFirstChildNode().getTreeNext();
		System.out.println(node);
		System.out.println("-----");
		PsiJavaFile javaFile = (PsiJavaFile) psiFile.getContainingFile();
		PsiPackage psiPackage = JavaPsiFacade.getInstance(project).findPackage(javaFile.getPackageName());
		System.out.println("psiPackage"  + psiPackage);

		ReferencesSearch.search()
//---------------------------
//		JavaFileType.INSTANCE;

		String currentText = document.getText();
		System.out.print(currentText);


	}
}
