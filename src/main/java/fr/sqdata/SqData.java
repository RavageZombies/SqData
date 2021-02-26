package fr.sqdata;

import fr.nico.sqript.ScriptManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

@Mod(modid = "sqdata", name = "SqData", dependencies = "required-after:sqript@[${version},);")
public class SqData {

    @Mod.EventHandler
    public void serverStarting(FMLServerStoppingEvent event) {
        System.out.println("saved informations");
        ScriptManager.stop();
    }

    @Mod.EventHandler
    public void preInit(FMLConstructionEvent event) {
        //ScriptManager.registerExpression(ExprDatabase.class, "database", new String[]{"Manipulate the Database with SDM"}, new String[]{"database"}, 1,new String[]{"get {string} from database {string}"});
    }
}
