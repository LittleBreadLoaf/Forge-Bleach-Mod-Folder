package littlebreadloaf.entities.renders;

import littlebreadloaf.entities.classes.EntityDecoy;
import littlebreadloaf.entities.classes.EntityFisher;
import littlebreadloaf.entities.classes.EntityHollowBat;
import littlebreadloaf.entities.classes.EntityHollowBlaze;
import littlebreadloaf.entities.classes.EntityHollowGolem;
import littlebreadloaf.entities.classes.EntityHollowOre;
import littlebreadloaf.entities.classes.EntityHollowSnake;
import littlebreadloaf.entities.classes.EntityHollowSpider;
import littlebreadloaf.entities.classes.EntityHollowStalker;
import littlebreadloaf.entities.classes.EntityHollowWasp;
import littlebreadloaf.entities.classes.EntityHollowWolf;
import littlebreadloaf.entities.classes.EntityMenosGrande;
import littlebreadloaf.entities.classes.EntityShinigami;
import littlebreadloaf.entities.classes.EntityWhole;
import littlebreadloaf.entities.models.ModelDecoy;
import littlebreadloaf.entities.models.ModelFisher;
import littlebreadloaf.entities.models.ModelHollowBat;
import littlebreadloaf.entities.models.ModelHollowBlaze;
import littlebreadloaf.entities.models.ModelHollowGolem;
import littlebreadloaf.entities.models.ModelHollowOre;
import littlebreadloaf.entities.models.ModelHollowSnake;
import littlebreadloaf.entities.models.ModelHollowSpider;
import littlebreadloaf.entities.models.ModelHollowStalker;
import littlebreadloaf.entities.models.ModelHollowWasp;
import littlebreadloaf.entities.models.ModelHollowWolf;
import littlebreadloaf.entities.models.ModelMenosGrande;
import littlebreadloaf.entities.models.ModelWhole;
import net.minecraft.client.model.ModelBiped;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class Renders
{

	public static void renderEntities()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityWhole.class, new RenderWhole(new ModelWhole(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityHollowBat.class, new RenderHollowBat(new ModelHollowBat(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityHollowBlaze.class, new RenderHollowBlaze(new ModelHollowBlaze(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityHollowSpider.class, new RenderHollowSpider(new ModelHollowSpider(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityHollowGolem.class, new RenderHollowGolem(new ModelHollowGolem(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityHollowSnake.class, new RenderHollowSnake(new ModelHollowSnake(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityHollowWasp.class, new RenderHollowWasp(new ModelHollowWasp(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityHollowStalker.class, new RenderHollowStalker(new ModelHollowStalker(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityHollowWolf.class, new RenderHollowWolf(new ModelHollowWolf(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityHollowOre.class, new RenderHollowOre(new ModelHollowOre(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityMenosGrande.class, new RenderMenosGrande(new ModelMenosGrande(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityFisher.class, new RenderFisher(new ModelFisher(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityDecoy.class, new RenderDecoy(new ModelDecoy(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityShinigami.class, new RenderShinigami(new ModelBiped(), 0.3F));
	}

}
