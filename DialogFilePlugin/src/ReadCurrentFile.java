import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiImportList;
import com.intellij.psi.PsiImportStatement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiRecursiveElementWalkingVisitor;
import com.intellij.psi.PsiTypeElement;
import com.intellij.psi.javadoc.PsiDocComment;


/**
 * Created by PamelaPeixinho on 19/03/17.
 * This simple plugin created to learn how to build an ToolWindow and extract PSI of files
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

		PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);

//		System.out.print(Arrays.toString(psiFile.getParent().getVirtualFile().getBOM()));
//		System.out.print(psiFile.getParent().getVirtualFile().getCanonicalFile().getCharset());

		System.out.println(psiFile.getLanguage());
		System.out.println(psiFile.getFileType());

//		FileASTNode astFileNodes = psiFile.getNode();
//		ASTNode node = astFileNodes.getFirstChildNode().getTreeNext();
//		System.out.println(node);
//		System.out.println("-----");
//		PsiJavaFile javaFile = (PsiJavaFile) psiFile.getContainingFile();
//		System.out.println("psiPackage"  + psiPackage);


//		List x = new List();
		psiFile.accept(new PsiRecursiveElementWalkingVisitor(){
			@Override
			public void visitElement(PsiElement element) {

//				----- JAVA ----
				if (element instanceof PsiMethod) {
					System.out.println("psi method = " + ((PsiMethod)element).getNameIdentifier().toString());
				} else if (element instanceof PsiImportList){
					for (PsiImportStatement importStatement : ((PsiImportList)element).getImportStatements()){
						System.out.println("psi PsiImportList = " + importStatement.getQualifiedName());
					}
				} else if (element instanceof PsiDocComment){
					System.out.println("psi psiDocComment Owner = " + ((PsiDocComment)element).getOwner().getName());
					System.out.println("psi psiDocComment = " + ((PsiDocComment)element).getText());
				} else if (element instanceof PsiTypeElement) {
					System.out.println("psi psiTypeElement  = " + ((PsiTypeElement)element).getType().toString());
				} else {
//					System.out.println("psi element = " + element.toString());
				}

//				----- Kotlin ----

//				if (element instanceof )


				super.visitElement(element);
			}
		});

//---------------------------
//		JavaFileType.INSTANCE;

//		String currentText = document.getText();
//		System.out.print(currentText);


	}
}
