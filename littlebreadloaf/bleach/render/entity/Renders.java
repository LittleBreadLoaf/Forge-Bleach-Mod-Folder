package littlebreadloaf.bleach.render.entity;

import littlebreadloaf.bleach.entities.EntityAshido;
import littlebreadloaf.bleach.entities.EntityDecoy;
import littlebreadloaf.bleach.entities.EntityFisher;
import littlebreadloaf.bleach.entities.EntityHollowBat;
import littlebreadloaf.bleach.entities.EntityHollowBlaze;
import littlebreadloaf.bleach.entities.EntityHollowGolem;
import littlebreadloaf.bleach.entities.EntityHollowOre;
import littlebreadloaf.bleach.entities.EntityHollowSnake;
import littlebreadloaf.bleach.entities.EntityHollowSpider;
import littlebreadloaf.bleach.entities.EntityHollowStalker;
import littlebreadloaf.bleach.entities.EntityHollowWasp;
import littlebreadloaf.bleach.entities.EntityHollowWolf;
import littlebreadloaf.bleach.entities.EntityMenosGrande;
import littlebreadloaf.bleach.entities.EntityShinigami;
import littlebreadloaf.bleach.entities.EntitySmallHollowLizard;
import littlebreadloaf.bleach.entities.EntityWhole;
import littlebreadloaf.bleach.render.models.ModelAshido;
import littlebreadloaf.bleach.render.models.ModelDecoy;
import littlebreadloaf.bleach.render.models.ModelFisher;
import littlebreadloaf.bleach.render.models.ModelHollowBat;
import littlebreadloaf.bleach.render.models.ModelHollowBlaze;
import littlebreadloaf.bleach.render.models.ModelHollowGolem;
import littlebreadloaf.bleach.render.models.ModelHollowOre;
import littlebreadloaf.bleach.render.models.ModelHollowSnake;
import littlebreadloaf.bleach.render.models.ModelHollowSpider;
import littlebreadloaf.bleach.render.models.ModelHollowStalker;
import littlebreadloaf.bleach.render.models.ModelHollowWasp;
import littlebreadloaf.bleach.render.models.ModelHollowWolf;
import littlebreadloaf.bleach.render.models.ModelMenosGrande;
import littlebreadloaf.bleach.render.models.ModelSmallHollowLizard;
import littlebreadloaf.bleach.render.models.ModelWhole;
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

		RenderingRegistry.registerEntityRenderingHandler(EntitySmallHollowLizard.class, new RenderSmallHollowLizard(new ModelSmallHollowLizard(), 0.3F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMenosGrande.class, new RenderMenosGrande(new ModelMenosGrande(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityFisher.class, new RenderFisher(new ModelFisher(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityDecoy.class, new RenderDecoy(new ModelDecoy(), 0.3F));

		RenderingRegistry.registerEntityRenderingHandler(EntityShinigami.class, new RenderShinigami(new ModelBiped(), 0.3F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityAshido.class, new RenderAshido(new ModelAshido(), 0.3F));
	}

}
