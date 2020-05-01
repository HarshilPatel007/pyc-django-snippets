import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ide.CopyPasteManager;
import org.jetbrains.annotations.NotNull;

import java.awt.datatransfer.StringSelection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR;


public class pycCopyDjangoModelFields extends AnAction {

    @Override
    public void actionPerformed(@NotNull final AnActionEvent e) {
        StringBuilder fields = new StringBuilder();
        Editor editor = e.getRequiredData(com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR);
        String SelectModel = editor.getSelectionModel().getSelectedText();
        String regex = "(\\S+)\\s*=\\s*[^(]*\\(([^)]*)\\)";
        Pattern pattern = Pattern.compile(regex);

        if (SelectModel == null) {
            return;
        }

        Matcher m = pattern.matcher(SelectModel);
        boolean first = true;
        while (m.find()) {
            if (first) {
                fields.append("fields = [ ");
                first = false;
            }
            fields.append("'");
            fields.append(m.group(1));
            fields.append("', ");
        }
        if (!first) {
            fields.append("]");
        }
        CopyPasteManager.getInstance().setContents(new StringSelection(fields.toString()));
    }
}
