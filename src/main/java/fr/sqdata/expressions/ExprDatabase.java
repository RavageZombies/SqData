package fr.sqdata.expressions;

import fr.nathanael2611.simpledatabasemanager.core.Database;
import fr.nathanael2611.simpledatabasemanager.core.Databases;
import fr.nico.sqript.compiling.ScriptException;
import fr.nico.sqript.expressions.ScriptExpression;
import fr.nico.sqript.meta.Expression;
import fr.nico.sqript.structures.ScriptContext;
import fr.nico.sqript.types.ScriptType;
import fr.nico.sqript.types.primitive.TypeString;

@Expression(
        name = "Database Expressions",
        description = {"Manipulate the Database with SDM"},
        examples = {"database"},
        patterns = {"get {string} from database {string}"}
)
public class ExprDatabase extends ScriptExpression {

    @Override
    public ScriptType get(ScriptContext scriptContext, ScriptType<?>[] scriptTypes) throws ScriptException {
        switch(this.getMatchedIndex()) {
            case 0:
                String key = (String) scriptTypes[0].getObject();
                String database = (String) scriptTypes[1].getObject();
                Database db = Databases.getDatabase(database);
                return new TypeString(db.get(key).asString());
        }
        return null;
    }

    @Override
    public boolean set(ScriptContext scriptContext, ScriptType scriptType, ScriptType<?>[] scriptTypes) throws ScriptException {
        return false;
    }
}
