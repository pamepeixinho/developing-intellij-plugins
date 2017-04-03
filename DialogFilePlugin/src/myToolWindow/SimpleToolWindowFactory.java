package myToolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.content.ContentFactory.SERVICE;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import org.jetbrains.annotations.NotNull;

/**
 * Created by PamelaPeixinho on 26/03/17.
 */
public class SimpleToolWindowFactory implements ToolWindowFactory {

	private JPanel myToolWindowContent;
	private JTextField queryField;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JTree code;
	private JScrollBar scrollBar1;
	private ToolWindow myToolWindow;

	public SimpleToolWindowFactory() {
		System.out.println("SimpleToolWindowFactory");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("actionPerformed");
			}
		});
		queryField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
				if (e.getKeyChar() == '\n') {
					System.out.println("Enter Pressed");
					System.out.println("queryField " + queryField.getText());
				}
			}
		});
	}

	@Override
	public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
		System.out.println("createToolWindowContent");
		System.out.println(toolWindow.isActive());

		this.myToolWindow = toolWindow;
		ContentFactory contentFactory = SERVICE.getInstance();
		Content content = contentFactory.createContent(myToolWindowContent, "", false);
		toolWindow.getContentManager().addContent(content);
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		myToolWindowContent = new JPanel();
		myToolWindowContent.setLayout(new GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
		button1 = new JButton();
		button1.setText("Button");
		button1.setMnemonic('B');
		button1.setDisplayedMnemonicIndex(0);
		myToolWindowContent.add(button1, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
																														GridConstraints.FILL_HORIZONTAL,
																														GridConstraints.SIZEPOLICY_CAN_SHRINK
																																| GridConstraints.SIZEPOLICY_CAN_GROW,
																														GridConstraints.SIZEPOLICY_FIXED, null,
																														null, null, 0, false));
		button2 = new JButton();
		button2.setText("Button");
		myToolWindowContent.add(button2, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
																														GridConstraints.FILL_HORIZONTAL,
																														GridConstraints.SIZEPOLICY_CAN_SHRINK
																																| GridConstraints.SIZEPOLICY_CAN_GROW,
																														GridConstraints.SIZEPOLICY_FIXED, null,
																														null, null, 0, false));
		button3 = new JButton();
		button3.setText("Button");
		myToolWindowContent.add(button3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
																														GridConstraints.FILL_HORIZONTAL,
																														GridConstraints.SIZEPOLICY_CAN_SHRINK
																																| GridConstraints.SIZEPOLICY_CAN_GROW,
																														GridConstraints.SIZEPOLICY_FIXED, null,
																														null, null, 0, false));
		code = new JTree();
		code.setAutoscrolls(true);
		code.setDragEnabled(true);
		code.setLargeModel(false);
		code.setName("testing");
		code.setToolTipText("blablabla");
		code.putClientProperty("html.disable", Boolean.FALSE);
		code.putClientProperty("JTree.lineStyle", "");
		myToolWindowContent.add(code,
				new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
															 GridConstraints.SIZEPOLICY_CAN_SHRINK
																	 | GridConstraints.SIZEPOLICY_WANT_GROW,
															 GridConstraints.SIZEPOLICY_CAN_SHRINK
																	 | GridConstraints.SIZEPOLICY_WANT_GROW, null,
															 new Dimension(150, 50), null, 0, false));
		queryField = new JTextField();
		queryField.setBackground(new Color(-1838863));
		queryField.setDropMode(DropMode.INSERT);
		queryField.setEditable(true);
		queryField.setEnabled(true);
		queryField.setText("");
		queryField.setToolTipText("Insert Text Here");
		myToolWindowContent.add(queryField, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST,
																															 GridConstraints.FILL_HORIZONTAL,
																															 GridConstraints.SIZEPOLICY_WANT_GROW,
																															 GridConstraints.SIZEPOLICY_CAN_SHRINK
																																	 | GridConstraints.SIZEPOLICY_CAN_GROW,
																															 null, new Dimension(150, -1), null,
																															 0, false));
		final JSeparator separator1 = new JSeparator();
		separator1.setAutoscrolls(true);
		myToolWindowContent.add(separator1,
				new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
															 GridConstraints.SIZEPOLICY_WANT_GROW,
															 GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		scrollBar1 = new JScrollBar();
		scrollBar1.setAutoscrolls(true);
		myToolWindowContent.add(scrollBar1,
				new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
															 GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_FIXED,
															 GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return myToolWindowContent;
	}
}
