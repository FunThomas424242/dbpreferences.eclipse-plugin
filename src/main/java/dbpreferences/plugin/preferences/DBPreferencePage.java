package dbpreferences.plugin.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import dbpreferences.plugin.Activator;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class DBPreferencePage extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {

    public DBPreferencePage() {
        super(GRID);
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
        setDescription("Preferences of JPA Connection");
    }

    /*
     * (non-Javadoc)
     * @see
     * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    public void init(IWorkbench workbench) {
    }

    @Override
    protected void createFieldEditors() {
        addField(new StringFieldEditor(PreferenceConstants.P_JPA_UNITNAME,
                "JPA Unit Name:", getFieldEditorParent()));
        addField(new StringFieldEditor(PreferenceConstants.P_USERNAME,
                "JDBC User Name:", getFieldEditorParent()));
        addField(new StringFieldEditor(PreferenceConstants.P_PASSWORD,
                "JDBC Password:", getFieldEditorParent()));
        addField(new StringFieldEditor(PreferenceConstants.P_DRIVERCLASS,
                "JDBC DB Driver Class Name:", getFieldEditorParent()));
        addField(new StringFieldEditor(PreferenceConstants.P_URL, "JDBC URL:",
                getFieldEditorParent()));
        addField(new RadioGroupFieldEditor(PreferenceConstants.P_LOGLEVEL,
                "DB Log Level", 1, new String[][] { { "&ERROR", "error" },
                        { "&DEBUG", "debug" }, { "&INFO", "info" },
                        { "&FINEST", "finest" } }, getFieldEditorParent()));

        addField(new RadioGroupFieldEditor(
                PreferenceConstants.P_WAEVING_INTERNAL, "JPA Waeving Internal",
                1,
                new String[][] { { "&FALSE", "false" }, { "&TRUE", "true" } },
                getFieldEditorParent()));
        addField(new RadioGroupFieldEditor(
                PreferenceConstants.P_DDL_GENERATION, "DDL Generation", 1,
                new String[][] { { "&None", "none" },
                        { "&DROP & CREATE", "dropcreate" }, },
                getFieldEditorParent()));
        addField(new RadioGroupFieldEditor(
                PreferenceConstants.P_DDL_GENERATION_MODE,
                "DDL Generation Mode", 1, new String[][] { { "&None", "none" },
                        { "&Database Creation", "database" } },
                getFieldEditorParent()));

    }

}
