package littlebreadloaf.bleach.player.models;

import org.lwjgl.opengl.GL11;

import littlebreadloaf.bleach.events.ExtendedPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;

public class ModelPlayerHollow extends ModelBiped
{
  //fields

    ModelRenderer default_head;
	ModelRenderer default_neck;
	
	ModelRenderer spitter_head;
    ModelRenderer spitter_head_eyeR;
    ModelRenderer spitter_head_jaws;
    ModelRenderer spitter_head_eyeL;
	
    ModelRenderer hornhead_1;
    ModelRenderer hornhead2;
    ModelRenderer hornhead3;
    ModelRenderer hornhead_4;
    ModelRenderer hornhead_jaw;
    ModelRenderer hornhead_hornR;
    ModelRenderer hornhead_hornL;
    
    ModelRenderer hard_head;
    ModelRenderer hard_head_face;
    ModelRenderer hard_head_top;
    ModelRenderer hard_head_side_R;
    ModelRenderer hard_head_sideL;
    ModelRenderer hard_head_fin;
    ModelRenderer hard_head_jaw;
    
    
	
    public ModelRenderer default_torso;
    ModelRenderer Default_lowertorso;
    ModelRenderer default_wing_stubR;
    ModelRenderer default_wing_stubL;

    ModelRenderer armored_backneck;
    ModelRenderer armored_backTR;
    ModelRenderer armored_back_BR;
    ModelRenderer armored_backTL;
    ModelRenderer armored_back_BL;
   
    ModelRenderer spike3R;
    ModelRenderer spike1R;
    ModelRenderer spike2R;
    ModelRenderer spike1L;
    ModelRenderer spike2L;
    ModelRenderer spike3L;
    
    ModelRenderer bugwing_R;
    ModelRenderer bugwing_L;
    
    
    
    
    
    ModelRenderer default_legL1;
    ModelRenderer default_legL2;
    ModelRenderer default_legL3;
    ModelRenderer default_legL4;
    ModelRenderer default_legL5;
    ModelRenderer default_legR1;
    ModelRenderer default_legR2;
    ModelRenderer default_legR3;
    ModelRenderer default_legR4;
    ModelRenderer default_legR5;
    
    ModelRenderer jumper_torso1;
    ModelRenderer jumper_torso2;
    ModelRenderer jumper_leg1R;
    ModelRenderer jumper_leg2R;
    ModelRenderer jumper_leg3R;
    ModelRenderer jumper_footR;
    ModelRenderer jumper_leg1L;
    ModelRenderer jumper_leg2L;
    ModelRenderer jumper_leg3L;
    ModelRenderer jumper_footL;
    
    ModelRenderer heavy_lower_torso2;
    ModelRenderer heavy_lower_torso1;
    ModelRenderer heavy_leg_2R;
    ModelRenderer heavy_leg_1R;
    ModelRenderer heavy_leg_1L;
    ModelRenderer heavy_leg_2L;
    
    ModelRenderer crawler_torso1;
    ModelRenderer crawler_torso2;
    ModelRenderer lower_crawler_torso1;
    ModelRenderer lower_crawler_torso2;
    ModelRenderer lower_crawler_torso3;
    ModelRenderer crawler_tail1;
    ModelRenderer crawler_tail2;
    ModelRenderer crawler_leg1BR;
    ModelRenderer crawler_leg1TR;
    ModelRenderer crawler_leg2BR;
    ModelRenderer crawler_leg5R;
    ModelRenderer crawler_leg2TR;
    ModelRenderer crawler_leg3R;
    ModelRenderer crawler_leg4R;
    ModelRenderer crawler_leg1TL;
    ModelRenderer crawler_leg1BL;
    ModelRenderer crawler_leg2TL;
    ModelRenderer crawler_leg2BL;
    ModelRenderer crawler_leg3L;
    ModelRenderer crawler_leg4L;
    ModelRenderer crawler_leg5L;
    
    
    
    public ModelRenderer default_armL1;
    public ModelRenderer default_armL2;
    public ModelRenderer default_armL3;
    public ModelRenderer default_armR1;
    public ModelRenderer default_armR2;
    public ModelRenderer default_armR3;
    
    ModelRenderer golem_armor_sholderL;
    ModelRenderer golem_sholderL;
    ModelRenderer golem_upper_armL;
    ModelRenderer golem_lower_armL;
    ModelRenderer golem_armor_lower_armL;
    ModelRenderer golem_armor_sholderR;
    ModelRenderer golem_sholderR;
    ModelRenderer golem_upper_armR;
    ModelRenderer golem_lower_armR;
    ModelRenderer golem_armor_lower_armR;
    
    ModelRenderer upper_claw_armL;
    ModelRenderer lower_claw_armL;
    ModelRenderer clawarmclaw1L;
    ModelRenderer clawarmclaw2L;
    ModelRenderer upper_claw_armR;
    ModelRenderer lower_claw_armR;
    ModelRenderer clawarmclaw1R;
    ModelRenderer clawarmclaw2R;
    
    ModelRenderer bug_lower_arm1L;
    ModelRenderer bug_lower_arm2L;
    ModelRenderer bug_upper_arm1L;
    ModelRenderer bug_upper_arm2L;
    ModelRenderer bug_lower_handL;
    ModelRenderer bug_upper_handL;
    ModelRenderer bug_lower_arm1R;
    ModelRenderer bug_lower_arm2R;
    ModelRenderer bug_upper_arm1R;
    ModelRenderer bug_upper_arm2R;
    ModelRenderer bug_lower_handR;
    ModelRenderer bug_upper_handR;
    
    
    ModelRenderer default_tail1;
    ModelRenderer default_tail2;
    ModelRenderer default_tail3;
    
    ModelRenderer wolf_tail_1;
    ModelRenderer wolf_tail_2;
    ModelRenderer wolf_tail_3;
    ModelRenderer wolf_tail_4;
    ModelRenderer wolf_tail_5;
    ModelRenderer wolf_tail_6;
    
    ModelRenderer shark_tail_1;
    ModelRenderer shark_tail_2;
    ModelRenderer shark_tail_3;
    ModelRenderer shark_tail_4;
    ModelRenderer shark_tail_fin;
    ModelRenderer shark_finsideR;
    ModelRenderer shark_finsideL;

    ModelRenderer scorpion_stinger1;
    ModelRenderer scorpion_stinger2;
    ModelRenderer scorpion_stinger3;
    ModelRenderer scorpion_tail1;
    ModelRenderer scorpion_tail2;
    ModelRenderer scorpion_tail3;
    ModelRenderer scorpion_tail4;
    ModelRenderer scorpion_tail5;
    ModelRenderer scorpion_tail6;
    ModelRenderer scorpion_tail7;
    ModelRenderer scorpion_tail8;
    ModelRenderer scorpion_tail9;
    
    
  
  public ModelPlayerHollow()
  {
    textureWidth = 512;
    textureHeight = 512;
    
      default_head = new ModelRenderer(this, 0, 0);
      default_head.addBox(-4F, -6F, -7F, 8, 8, 8);
      default_head.setRotationPoint(0F, -7.5F, 0F);
      default_head.setTextureSize(512, 512);
      default_head.mirror = true;
      setRotation(default_head, 0F, 0F, 0F);
      default_neck = new ModelRenderer(this, 33, 0);
      default_neck.addBox(-2F, -16F, 1F, 4, 3, 4);
      default_neck.setRotationPoint(0F, 9F, 0F);
      default_neck.setTextureSize(512, 512);
      default_neck.mirror = true;
      setRotation(default_neck, 0.2617994F, 0F, 0F);
      
      spitter_head = new ModelRenderer(this, 400, 58);
      spitter_head.addBox(-3F, -6F, -8F, 6, 6, 10);
      spitter_head.setRotationPoint(0F, -7F, 0F);
      spitter_head.setTextureSize(512, 512);
      spitter_head.mirror = true;
      setRotation(spitter_head, 0.5235988F, 0F, 0F);
      spitter_head_eyeR = new ModelRenderer(this, 400, 77);
      spitter_head_eyeR.mirror = true;
      spitter_head_eyeR.addBox(-7F, -4F, -8F, 5, 4, 6);
      spitter_head_eyeR.setRotationPoint(0F, 0F, 0F);
      spitter_head_eyeR.setTextureSize(512, 512);
      spitter_head_eyeR.mirror = true;
      setRotation(spitter_head_eyeR, -0.5235988F, 0F, 0.2617994F);
      spitter_head_eyeR.mirror = false;
      spitter_head_jaws = new ModelRenderer(this, 400, 89);
      spitter_head_jaws.addBox(-3.5F, 0F, -11F, 7, 4, 8);
      spitter_head_jaws.setRotationPoint(0F, 0F, 0F);
      spitter_head_jaws.setTextureSize(512, 512);
      spitter_head_jaws.mirror = true;
      setRotation(spitter_head_jaws, -0.5235988F, 0F, 0F);
      spitter_head_eyeL = new ModelRenderer(this, 400, 77);
      spitter_head_eyeL.addBox(2F, -4F, -8F, 5, 4, 6);
      spitter_head_eyeL.setRotationPoint(0F, 0F, 0F);
      spitter_head_eyeL.setTextureSize(512, 512);
      spitter_head_eyeL.mirror = true;
      setRotation(spitter_head_eyeL, -0.5235988F, 0F, -0.2617994F);
      
      hornhead_1 = new ModelRenderer(this, 400, 0);
      hornhead_1.addBox(-4.5F, -6F, -7F, 9, 8, 9);
      hornhead_1.setRotationPoint(0F, -7F, 0F);
      hornhead_1.setTextureSize(512, 512);
      hornhead_1.mirror = true;
      setRotation(hornhead_1, 0.2617994F, 0F, 0F);
      hornhead2 = new ModelRenderer(this, 400, 30);
      hornhead2.addBox(-4F, -6F, -8F, 8, 2, 3);
      hornhead2.setRotationPoint(0F, 0F, 0F);
      hornhead2.setTextureSize(512, 512);
      hornhead2.mirror = true;
      setRotation(hornhead2, 0.0174533F - 0.2617994F, 0F, 0F);
      hornhead3 = new ModelRenderer(this, 400, 38);
      hornhead3.addBox(-3F, -9.5F, -1.5F, 6, 3, 3);
      hornhead3.setRotationPoint(0F, 0F, 0F);
      hornhead3.setTextureSize(512, 512);
      hornhead3.mirror = true;
      setRotation(hornhead3, 0.7853982F - 0.2617994F, 0F, 0F);
      hornhead_4 = new ModelRenderer(this, 400, 46);
      hornhead_4.addBox(-2F, -7F, -5F, 4, 3, 8);
      hornhead_4.setRotationPoint(0F, 0F, 0F);
      hornhead_4.setTextureSize(512, 512);
      hornhead_4.mirror = true;
      setRotation(hornhead_4, -0.2617994F, 0F, 0F);
      hornhead_jaw = new ModelRenderer(this, 400, 19);
      hornhead_jaw.addBox(-3F, 3F, -6F, 6, 3, 5);
      hornhead_jaw.setRotationPoint(0F, 0F, 0F);
      hornhead_jaw.setTextureSize(512, 512);
      hornhead_jaw.mirror = true;
      setRotation(hornhead_jaw, -0.2617994F - 0.2617994F, 0F, 0F);
      hornhead_hornR = new ModelRenderer(this, 425, 20);
      hornhead_hornR.mirror = true;
      hornhead_hornR.addBox(-6F, -5F, -12F, 2, 2, 7);
      hornhead_hornR.setRotationPoint(0F, 0F, 0F);
      hornhead_hornR.setTextureSize(512, 512);
      hornhead_hornR.mirror = true;
      setRotation(hornhead_hornR, -0.2617994F, 0F, 0F);
      hornhead_hornR.mirror = false;
      hornhead_hornL = new ModelRenderer(this, 425, 20);
      hornhead_hornL.addBox(4F, -5F, -12F, 2, 2, 7);
      hornhead_hornL.setRotationPoint(0F, 0F, 0F);
      hornhead_hornL.setTextureSize(512, 512);
      hornhead_hornL.mirror = true;
      setRotation(hornhead_hornL, -0.2617994F, 0F, 0F);

      hard_head = new ModelRenderer(this, 400, 107);
      hard_head.addBox(-4F, -6F, -7F, 8, 8, 8);
      hard_head.setRotationPoint(0F, -7F, 0F);
      hard_head.setTextureSize(512, 512);
      hard_head.mirror = true;
      setRotation(hard_head, 0F, 0F, 0F);
      hard_head_face = new ModelRenderer(this, 400, 127);
      hard_head_face.addBox(-3F, -5F, -8F, 6, 6, 1);
      hard_head_face.setRotationPoint(0F, 0F, 0F);
      hard_head_face.setTextureSize(512, 512);
      hard_head_face.mirror = true;
      setRotation(hard_head_face, 0F, 0F, 0F);
      hard_head_top = new ModelRenderer(this, 400, 137);
      hard_head_top.addBox(-3F, -7F, -6F, 6, 1, 6);
      hard_head_top.setRotationPoint(0F, 0F, 0F);
      hard_head_top.setTextureSize(512, 512);
      hard_head_top.mirror = true;
      setRotation(hard_head_top, 0F, 0F, 0F);
      hard_head_side_R = new ModelRenderer(this, 435, 107);
      hard_head_side_R.addBox(-5F, -5F, -6F, 1, 6, 6);
      hard_head_side_R.setRotationPoint(0F, 0F, 0F);
      hard_head_side_R.setTextureSize(512, 512);
      hard_head_side_R.mirror = true;
      setRotation(hard_head_side_R, 0F, 0F, 0F);
      hard_head_sideL = new ModelRenderer(this, 435, 107);
      hard_head_sideL.addBox(4F, -5F, -6F, 1, 6, 6);
      hard_head_sideL.setRotationPoint(0F, 0F, 0F);
      hard_head_sideL.setTextureSize(512, 512);
      hard_head_sideL.mirror = true;
      setRotation(hard_head_sideL, 0F, 0F, 0F);
      hard_head_fin = new ModelRenderer(this, 428, 138);
      hard_head_fin.addBox(-1F, -7.5F, -8.5F, 2, 5, 10);
      hard_head_fin.setRotationPoint(0F, 0F, 0F);
      hard_head_fin.setTextureSize(512, 512);
      hard_head_fin.mirror = true;
      setRotation(hard_head_fin, 0F, 0F, 0F);
      hard_head_jaw = new ModelRenderer(this, 418, 127);
      hard_head_jaw.addBox(-4.5F, 1F, -8F, 9, 3, 4);
      hard_head_jaw.setRotationPoint(0F, 0F, 0F);
      hard_head_jaw.setTextureSize(512, 512);
      hard_head_jaw.mirror = true;
      setRotation(hard_head_jaw, -0.2617994F, 0F, 0F);
      
      
      
      

      default_torso = new ModelRenderer(this, 0, 17);
      default_torso.addBox(-6F, -13F, 0F, 12, 8, 8);
      default_torso.setRotationPoint(0F, 9F, 0F);
      default_torso.setTextureSize(512, 512);
      default_torso.mirror = true;
      setRotation(default_torso, 0.3141593F, 0F, 0F);
      Default_lowertorso = new ModelRenderer(this, 0, 34);
      Default_lowertorso.addBox(-4F, -7F, -1F, 8, 8, 6);
      Default_lowertorso.setRotationPoint(0F, 9F, 0F);
      Default_lowertorso.setTextureSize(512, 512);
      Default_lowertorso.mirror = true;
      setRotation(Default_lowertorso, 0F, 0F, 0F);
      
      jumper_torso1 = new ModelRenderer(this, 0, 152);
      jumper_torso1.addBox(-3.5F, -7F, 0F, 7, 5, 5);
      jumper_torso1.setRotationPoint(0F, 9F, 0F);
      jumper_torso1.setTextureSize(512, 512);
      jumper_torso1.mirror = true;
      setRotation(jumper_torso1, 0F, 0F, 0F);
      jumper_torso2 = new ModelRenderer(this, 0, 165);
      jumper_torso2.addBox(-4F, -2F, -1F, 8, 3, 5);
      jumper_torso2.setRotationPoint(0F, 9F, 0F);
      jumper_torso2.setTextureSize(512, 512);
      jumper_torso2.mirror = true;
      setRotation(jumper_torso2, 0F, 0F, 0F);
      
      armored_backTR = new ModelRenderer(this, 41, 492);
      armored_backTR.mirror = true;
      armored_backTR.addBox(-5.5F, -16F, -4F, 3, 9, 9);
      armored_backTR.setRotationPoint(0F, 9F, 0F);
      armored_backTR.setTextureSize(512, 512);
      armored_backTR.mirror = true;
      setRotation(armored_backTR, 0F, 0F, 0F);
      armored_backTR.mirror = false;
      armored_backneck = new ModelRenderer(this, 70, 489);
      armored_backneck.addBox(-3F, -16F, 2F, 6, 3, 3);
      armored_backneck.setRotationPoint(0F, 9F, 0F);
      armored_backneck.setTextureSize(512, 512);
      armored_backneck.mirror = true;
      setRotation(armored_backneck, 0F, 0F, 0F);
      armored_back_BR = new ModelRenderer(this, 68, 498);
      armored_back_BR.mirror = true;
      armored_back_BR.addBox(-6.5F, -6.5F, -1F, 5, 3, 9);
      armored_back_BR.setRotationPoint(0F, 8F, 0F);
      armored_back_BR.setTextureSize(512, 512);
      armored_back_BR.mirror = true;
      setRotation(armored_back_BR, 0.3141593F, 0F, 0F);
      armored_back_BR.mirror = false;
      armored_backTL = new ModelRenderer(this, 41, 492);
      armored_backTL.addBox(2.5F, -16F, -4F, 3, 9, 9);
      armored_backTL.setRotationPoint(0F, 9F, 0F);
      armored_backTL.setTextureSize(512, 512);
      armored_backTL.mirror = true;
      setRotation(armored_backTL, 0F, 0F, 0F);
      armored_back_BL = new ModelRenderer(this, 68, 498);
      armored_back_BL.addBox(1.5F, -6.5F, -1F, 5, 3, 9);
      armored_back_BL.setRotationPoint(0F, 8F, 0F);
      armored_back_BL.setTextureSize(512, 512);
      armored_back_BL.mirror = true;
      setRotation(armored_back_BL, 0.3141593F, 0F, 0F);

      spike3R = new ModelRenderer(this, 95, 490);
      spike3R.addBox(-3F, -16F, -8F, 1, 10, 1);
      spike3R.setRotationPoint(0F, 9F, 0F);
      spike3R.setTextureSize(512, 512);
      spike3R.mirror = true;
      setRotation(spike3R, -1.308997F, -0.0872665F, 0F);
      spike3R.mirror = false;
      spike1R = new ModelRenderer(this, 95, 490);
      spike1R.addBox(-2F, -22F, -7F, 1, 10, 1);
      spike1R.setRotationPoint(0F, 9F, 0F);
      spike1R.setTextureSize(512, 512);
      spike1R.mirror = true;
      setRotation(spike1R, -0.7853982F, -0.5235988F, 0F);
      spike1R.mirror = false;
      spike2R = new ModelRenderer(this, 95, 490);
      spike2R.addBox(-3F, -19F, -8F, 1, 10, 1);
      spike2R.setRotationPoint(0F, 9F, 0F);
      spike2R.setTextureSize(512, 512);
      spike2R.mirror = true;
      setRotation(spike2R, -1.047198F, -0.2617994F, 0F);
      spike2R.mirror = false;
      spike1L = new ModelRenderer(this, 95, 490);
      spike1L.addBox(1F, -22F, -7F, 1, 10, 1);
      spike1L.setRotationPoint(0F, 9F, 0F);
      spike1L.setTextureSize(512, 512);
      spike1L.mirror = true;
      setRotation(spike1L, -0.7853982F, 0.5235988F, 0F);
      spike2L = new ModelRenderer(this, 95, 490);
      spike2L.addBox(2F, -19F, -8F, 1, 10, 1);
      spike2L.setRotationPoint(0F, 9F, 0F);
      spike2L.setTextureSize(512, 512);
      spike2L.mirror = true;
      setRotation(spike2L, -1.047198F, 0.2617994F, 0F);
      spike3L = new ModelRenderer(this, 95, 490);
      spike3L.addBox(2F, -16F, -8F, 1, 10, 1);
      spike3L.setRotationPoint(0F, 9F, 0F);
      spike3L.setTextureSize(512, 512);
      spike3L.mirror = true;
      setRotation(spike3L, -1.308997F, 0.0872665F, 0F);
      
      bugwing_R = new ModelRenderer(this, 0, 479);
      bugwing_R.addBox(0F, -3F, -1F, 0, 11, 20);
      bugwing_R.setRotationPoint(-3F, -3F, 5F);
      bugwing_R.setTextureSize(512, 512);
      bugwing_R.mirror = true;
      setRotation(bugwing_R, 0.7853982F, -0.5235988F, 0F);
      bugwing_R.mirror = false;
      bugwing_L = new ModelRenderer(this, 0, 479);
      bugwing_L.addBox(0F, -3F, -1F, 0, 11, 20);
      bugwing_L.setRotationPoint(3F, -3F, 5F);
      bugwing_L.setTextureSize(512, 512);
      bugwing_L.mirror = true;
      setRotation(bugwing_L, 0.7853982F, 0.5235988F, 0F);
      
      
      
      default_legL1 = new ModelRenderer(this, 0, 49);
      default_legL1.addBox(-2F, -2F, -2F, 4, 8, 4);
      default_legL1.setRotationPoint(4F, 9F, 2F);
      default_legL1.setTextureSize(512, 512);
      default_legL1.mirror = true;
      setRotation(default_legL1, -0.5235988F, 0F, 0F);
      default_legL2 = new ModelRenderer(this, 0, 62);
      default_legL2.addBox(-3F, 2F, -6F, 6, 10, 4);
      default_legL2.setRotationPoint(0F, 0F, 0F);
      default_legL2.setTextureSize(512, 512);
      default_legL2.mirror = true;
      setRotation(default_legL2, 0.2617994F + 0.5235988F, 0F, 0F);
      default_legL3 = new ModelRenderer(this, 0, 76);
      default_legL3.addBox(-3.5F, 12F, -4F, 7, 3, 5);
      default_legL3.setRotationPoint(0F, 0F, 0F);
      default_legL3.setTextureSize(512, 512);
      default_legL3.mirror = true;
      setRotation(default_legL3, -0.2617994F, 0F, 0F);
      default_legL4 = new ModelRenderer(this, 0, 85);
      default_legL4.addBox(-3F, 13F, -5F, 2, 2, 1);
      default_legL4.setRotationPoint(0F, 0F, 0F);
      default_legL4.setTextureSize(512, 512);
      default_legL4.mirror = true;
      setRotation(default_legL4, 0F, 0F, 0F);
      default_legL5 = new ModelRenderer(this, 0, 85);
      default_legL5.addBox(1F, 13F, -5F, 2, 2, 1);
      default_legL5.setRotationPoint(0F, 0F, 0F);
      default_legL5.setTextureSize(512, 512);
      default_legL5.mirror = true;
      setRotation(default_legL5, 0F, 0F, 0F);
      default_legR1 = new ModelRenderer(this, 0, 49);
      default_legR1.mirror = true;
      default_legR1.addBox(-2F, -2F, -2F, 4, 8, 4);
      default_legR1.setRotationPoint(-4F, 9F, 2F);
      default_legR1.setTextureSize(512, 512);
      default_legR1.mirror = true;
      setRotation(default_legR1, -0.5235988F, 0F, 0F);
      default_legR1.mirror = false;
      default_legR2 = new ModelRenderer(this, 0, 62);
      default_legR2.mirror = true;
      default_legR2.addBox(-3F, 2F, -6F, 6, 10, 4);
      default_legR2.setRotationPoint(0F, 0F, 0F);
      default_legR2.setTextureSize(512, 512);
      default_legR2.mirror = true;
      setRotation(default_legR2, 0.2617994F + 0.5235988F, 0F, 0F);
      default_legR2.mirror = false;
      default_legR3 = new ModelRenderer(this, 0, 76);
      default_legR3.mirror = true;
      default_legR3.addBox(-3.5F, 12F, -4F, 7, 3, 5);
      default_legR3.setRotationPoint(0F, 0F, 0F);
      default_legR3.setTextureSize(512, 512);
      default_legR3.mirror = true;
      setRotation(default_legR3, -0.2617994F, 0F, 0F);
      default_legR3.mirror = false;
      default_legR4 = new ModelRenderer(this, 0, 85);
      default_legR4.mirror = true;
      default_legR4.addBox(1F, 13F, -5F, 2, 2, 1);
      default_legR4.setRotationPoint(0F, 0F, 0F);
      default_legR4.setTextureSize(512, 512);
      default_legR4.mirror = true;
      setRotation(default_legR4, 0F, 0F, 0F);
      default_legR4.mirror = false;
      default_legR5 = new ModelRenderer(this, 0, 85);
      default_legR5.mirror = true;
      default_legR5.addBox(-3F, 13F, -5F, 2, 2, 1);
      default_legR5.setRotationPoint(0F, 0F, 0F);
      default_legR5.setTextureSize(512, 512);
      default_legR5.mirror = true;
      setRotation(default_legR5, 0F, 0F, 0F);
      default_legR5.mirror = false;
      
      jumper_leg1R = new ModelRenderer(this, 0, 176);
      jumper_leg1R.mirror = true;
      jumper_leg1R.addBox(-1.5F, -2F, -1F, 3, 7, 4);
      jumper_leg1R.setRotationPoint(-5F, 9F, 0F);
      jumper_leg1R.setTextureSize(512, 512);
      jumper_leg1R.mirror = true;
      setRotation(jumper_leg1R, -0.5235988F, 0F, 0F);
      jumper_leg1R.mirror = false;
      jumper_leg2R = new ModelRenderer(this, 16, 176);
      jumper_leg2R.mirror = true;
      jumper_leg2R.addBox(-1F, 4F, -1F, 2, 2, 7);
      jumper_leg2R.setRotationPoint(0F, 0F, 0F);
      jumper_leg2R.setTextureSize(512, 512);
      jumper_leg2R.mirror = true;
      setRotation(jumper_leg2R, -0.2617994F + 0.5235988F, 0F, 0F);
      jumper_leg2R.mirror = false;
      jumper_leg3R = new ModelRenderer(this, 0, 192);
      jumper_leg3R.mirror = true;
      jumper_leg3R.addBox(-1.5F, 5F, 4F, 3, 8, 3);
      jumper_leg3R.setRotationPoint(0F, 0F, 0F);
      jumper_leg3R.setTextureSize(512, 512);
      jumper_leg3R.mirror = true;
      setRotation(jumper_leg3R, 0F, 0F, 0F);
      jumper_leg3R.mirror = false;
      jumper_footR = new ModelRenderer(this, 17, 192);
      jumper_footR.mirror = true;
      jumper_footR.addBox(-2F, 13F, -2F, 4, 2, 5);
      jumper_footR.setRotationPoint(0F, 0F, 0F);
      jumper_footR.setTextureSize(512, 512);
      jumper_footR.mirror = true;
      setRotation(jumper_footR, 0.2617994F, 0F, 0F);
      jumper_footR.mirror = false;
      jumper_leg1L = new ModelRenderer(this, 0, 176);
      jumper_leg1L.addBox(-1.5F, -2F, -1F, 3, 7, 4);
      jumper_leg1L.setRotationPoint(5F, 9F, 0F);
      jumper_leg1L.setTextureSize(512, 512);
      jumper_leg1L.mirror = true;
      setRotation(jumper_leg1L, -0.5235988F, 0F, 0F);
      jumper_leg2L = new ModelRenderer(this, 16, 176);
      jumper_leg2L.addBox(-1F, 4F, -1F, 2, 2, 7);
      jumper_leg2L.setRotationPoint(0F, 0F, 0F);
      jumper_leg2L.setTextureSize(512, 512);
      jumper_leg2L.mirror = true;
      setRotation(jumper_leg2L, -0.2617994F + 0.5235988F, 0F, 0F);
      jumper_leg3L = new ModelRenderer(this, 0, 192);
      jumper_leg3L.addBox(-1.5F, 5F, 4F, 3, 8, 3);
      jumper_leg3L.setRotationPoint(0F, 0F, 0F);
      jumper_leg3L.setTextureSize(512, 512);
      jumper_leg3L.mirror = true;
      setRotation(jumper_leg3L, 0F, 0F, 0F);
      jumper_footL = new ModelRenderer(this, 17, 192);
      jumper_footL.addBox(-2F, 13F, -2F, 4, 2, 5);
      jumper_footL.setRotationPoint(0F, 0F, 0F);
      jumper_footL.setTextureSize(512, 512);
      jumper_footL.mirror = true;
      setRotation(jumper_footL, 0.2617994F, 0F, 0F);

      heavy_lower_torso2 = new ModelRenderer(this, 0, 332);
      heavy_lower_torso2.addBox(-2.5F, -2F, -1F, 5, 5, 6);
      heavy_lower_torso2.setRotationPoint(0F, 9F, 0F);
      heavy_lower_torso2.setTextureSize(512, 512);
      heavy_lower_torso2.mirror = true;
      setRotation(heavy_lower_torso2, 0F, 0F, 0F);
      heavy_lower_torso1 = new ModelRenderer(this, 0, 314);
      heavy_lower_torso1.addBox(-4.5F, -8F, -2.5F, 9, 6, 9);
      heavy_lower_torso1.setRotationPoint(0F, 9F, 0F);
      heavy_lower_torso1.setTextureSize(512, 512);
      heavy_lower_torso1.mirror = true;
      setRotation(heavy_lower_torso1, 0F, 0F, 0F);
      heavy_leg_2R = new ModelRenderer(this, 0, 363);
      heavy_leg_2R.mirror = true;
      heavy_leg_2R.addBox(-4.5F, 5F, -5F, 7, 9, 8);
      heavy_leg_2R.setRotationPoint(0F, 0F, 0F);
      heavy_leg_2R.setTextureSize(512, 512);
      heavy_leg_2R.mirror = true;
      setRotation(heavy_leg_2R, 0.2617994F, 0F, 0F);
      heavy_leg_2R.mirror = false;
      heavy_leg_1R = new ModelRenderer(this, 0, 346);
      heavy_leg_1R.mirror = true;
      heavy_leg_1R.addBox(-4F, -2F, -3F, 6, 8, 7);
      heavy_leg_1R.setRotationPoint(-3F, 10F, 1F);
      heavy_leg_1R.setTextureSize(512, 512);
      heavy_leg_1R.mirror = true;
      setRotation(heavy_leg_1R, -0.2617994F, 0F, 0F);
      heavy_leg_1R.mirror = false;
      heavy_leg_1L = new ModelRenderer(this, 0, 346);
      heavy_leg_1L.addBox(-2F, -2F, -3F, 6, 8, 7);
      heavy_leg_1L.setRotationPoint(3F, 10F, 1F);
      heavy_leg_1L.setTextureSize(512, 512);
      heavy_leg_1L.mirror = true;
      setRotation(heavy_leg_1L, -0.2617994F, 0F, 0F);
      heavy_leg_2L = new ModelRenderer(this, 0, 363);
      heavy_leg_2L.addBox(-2.5F, 5F, -5F, 7, 9, 8);
      heavy_leg_2L.setRotationPoint(0F, 0F, 0F);
      heavy_leg_2L.setTextureSize(512, 512);
      heavy_leg_2L.mirror = true;
      setRotation(heavy_leg_2L, 0.2617994F, 0F, 0F);
      
      crawler_torso1 = new ModelRenderer(this, 0, 204);
      crawler_torso1.addBox(-5F, -7F, -1F, 10, 6, 6);
      crawler_torso1.setRotationPoint(0F, 9F, 0F);
      crawler_torso1.setTextureSize(512, 512);
      crawler_torso1.mirror = true;
      setRotation(crawler_torso1, 0F, 0F, 0F);
      crawler_torso2 = new ModelRenderer(this, 0, 217);
      crawler_torso2.addBox(-4F, -3F, -2F, 8, 9, 5);
      crawler_torso2.setRotationPoint(0F, 9F, 0F);
      crawler_torso2.setTextureSize(512, 512);
      crawler_torso2.mirror = true;
      setRotation(crawler_torso2, -0.5235988F, 0F, 0F);
      lower_crawler_torso1 = new ModelRenderer(this, 0, 233);
      lower_crawler_torso1.addBox(-3F, -2F, -1F, 6, 5, 5);
      lower_crawler_torso1.setRotationPoint(0F, 6F, 0F);
      lower_crawler_torso1.setTextureSize(512, 512);
      lower_crawler_torso1.mirror = true;
      setRotation(lower_crawler_torso1, 0.5235988F, 0F, 0F);
      lower_crawler_torso2 = new ModelRenderer(this, 25, 233);
      lower_crawler_torso2.addBox(-2.5F, 2F, -2F, 5, 7, 5);
      lower_crawler_torso2.setRotationPoint(0F, 0F, 0F);
      lower_crawler_torso2.setTextureSize(512, 512);
      lower_crawler_torso2.mirror = true;
      setRotation(lower_crawler_torso2, 0.5235988F, 0F, 0F);
      lower_crawler_torso3 = new ModelRenderer(this, 0, 245);
      lower_crawler_torso3.addBox(-2F, 5F, 3F, 4, 4, 9);
      lower_crawler_torso3.setRotationPoint(0F, 0F, 0F);
      lower_crawler_torso3.setTextureSize(512, 512);
      lower_crawler_torso3.mirror = true;
      setRotation(lower_crawler_torso3, -0.5235988F, 0F, 0F);
      crawler_tail1 = new ModelRenderer(this, 0, 259);
      crawler_tail1.addBox(-1.5F, 12F, 2F, 3, 3, 9);
      crawler_tail1.setRotationPoint(0F, 0F, 0F);
      crawler_tail1.setTextureSize(512, 512);
      crawler_tail1.mirror = true;
      setRotation(crawler_tail1, 0.7853982F, 0F, 0F);
      crawler_tail2 = new ModelRenderer(this, 0, 273);
      crawler_tail2.addBox(-1F, 6F, 16F, 2, 2, 6);
      crawler_tail2.setRotationPoint(0F, 0F, 0F);
      crawler_tail2.setTextureSize(512, 512);
      crawler_tail2.mirror = true;
      setRotation(crawler_tail2, 0.2617994F - 0.7853982F, 0F, 0F);
      crawler_leg1BR = new ModelRenderer(this, 0, 295);
      crawler_leg1BR.mirror = true;
      crawler_leg1BR.addBox(-0.5F, 2F, -4.5F, 1, 6, 1);
      crawler_leg1BR.setRotationPoint(0F, 0F, 0F);
      crawler_leg1BR.setTextureSize(512, 512);
      crawler_leg1BR.mirror = true;
      setRotation(crawler_leg1BR, -0.3617994F, 0F, 0F);
      crawler_leg1BR.mirror = false;
      crawler_leg1TR = new ModelRenderer(this, 0, 285);
      crawler_leg1TR.mirror = true;
      crawler_leg1TR.addBox(-1F, -1F, -5F, 2, 2, 6);
      crawler_leg1TR.setRotationPoint(-4F, 3F, -2F);
      crawler_leg1TR.setTextureSize(512, 512);
      crawler_leg1TR.mirror = true;
      setRotation(crawler_leg1TR, 0.2617994F, 0.5235988F, 0F);
      crawler_leg1TR.mirror = false;
      crawler_leg2BR = new ModelRenderer(this, 9, 295);
      crawler_leg2BR.mirror = true;
      crawler_leg2BR.addBox(-3.5F, 1.5F, -0.5F, 1, 8, 1);
      crawler_leg2BR.setRotationPoint(0F, 0F, 0F);
      crawler_leg2BR.setTextureSize(512, 512);
      crawler_leg2BR.mirror = true;
      setRotation(crawler_leg2BR, 0F, 0F, 0.5235988F);
      crawler_leg2BR.mirror = false;
      crawler_leg5R = new ModelRenderer(this, 0, 321);
      crawler_leg5R.mirror = true;
      crawler_leg5R.addBox(-4F, -0.5F, -0.5F, 4, 1, 1);
      crawler_leg5R.setRotationPoint(-2F, 7F, 11F);
      crawler_leg5R.setTextureSize(512, 512);
      crawler_leg5R.mirror = true;
      setRotation(crawler_leg5R, 0.5235988F, 0.7853982F, -0.7853982F);
      crawler_leg5R.mirror = false;
      crawler_leg2TR = new ModelRenderer(this, 18, 289);
      crawler_leg2TR.mirror = true;
      crawler_leg2TR.addBox(-4F, -1F, -1F, 5, 2, 2);
      crawler_leg2TR.setRotationPoint(-3F, 2F, 1F);
      crawler_leg2TR.setTextureSize(512, 512);
      crawler_leg2TR.mirror = true;
      setRotation(crawler_leg2TR, 0F, -0.3490659F, 0F);
      crawler_leg2TR.mirror = false;
      crawler_leg3R = new ModelRenderer(this, 0, 309);
      crawler_leg3R.mirror = true;
      crawler_leg3R.addBox(-5F, -0.5F, -0.5F, 5, 1, 1);
      crawler_leg3R.setRotationPoint(-2F, 7F, 0F);
      crawler_leg3R.setTextureSize(512, 512);
      crawler_leg3R.mirror = true;
      setRotation(crawler_leg3R, -0.5235988F, 0F, -0.7853982F);
      crawler_leg3R.mirror = false;
      crawler_leg4R = new ModelRenderer(this, 0, 315);
      crawler_leg4R.mirror = true;
      crawler_leg4R.addBox(-4F, -0.5F, -0.5F, 4, 1, 1);
      crawler_leg4R.setRotationPoint(-2F, 6F, 7F);
      crawler_leg4R.setTextureSize(512, 512);
      crawler_leg4R.mirror = true;
      setRotation(crawler_leg4R, 0.5235988F, 0F, -0.7853982F);
      crawler_leg4R.mirror = false;
      crawler_leg1TL = new ModelRenderer(this, 0, 285);
      crawler_leg1TL.addBox(-1F, -1F, -5F, 2, 2, 6);
      crawler_leg1TL.setRotationPoint(4F, 3F, -2F);
      crawler_leg1TL.setTextureSize(512, 512);
      crawler_leg1TL.mirror = true;
      setRotation(crawler_leg1TL, 0.2617994F, -0.5235988F, 0F);
      crawler_leg1BL = new ModelRenderer(this, 0, 295);
      crawler_leg1BL.addBox(-0.5F, 2F, -4.5F, 1, 6, 1);
      crawler_leg1BL.setRotationPoint(0F, 0F, 0F);
      crawler_leg1BL.setTextureSize(512, 512);
      crawler_leg1BL.mirror = true;
      setRotation(crawler_leg1BL, -0.3617994F, 0F, 0F);
      crawler_leg2TL = new ModelRenderer(this, 18, 289);
      crawler_leg2TL.addBox(-1F, -1F, -1F, 5, 2, 2);
      crawler_leg2TL.setRotationPoint(3F, 2F, 1F);
      crawler_leg2TL.setTextureSize(512, 512);
      crawler_leg2TL.mirror = true;
      setRotation(crawler_leg2TL, 0F, 0.3490659F, 0F);
      crawler_leg2BL = new ModelRenderer(this, 9, 295);
      crawler_leg2BL.addBox(2.5F, 1.5F, -0.5F, 1, 8, 1);
      crawler_leg2BL.setRotationPoint(0F, 0F, 0F);
      crawler_leg2BL.setTextureSize(512, 512);
      crawler_leg2BL.mirror = true;
      setRotation(crawler_leg2BL, 0F, 0F, -0.5235988F);
      crawler_leg3L = new ModelRenderer(this, 0, 309);
      crawler_leg3L.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
      crawler_leg3L.setRotationPoint(2F, 7F, 0F);
      crawler_leg3L.setTextureSize(512, 512);
      crawler_leg3L.mirror = true;
      setRotation(crawler_leg3L, -0.5235988F, 0F, 0.7853982F);
      crawler_leg4L = new ModelRenderer(this, 0, 315);
      crawler_leg4L.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
      crawler_leg4L.setRotationPoint(2F, 6F, 7F);
      crawler_leg4L.setTextureSize(512, 512);
      crawler_leg4L.mirror = true;
      setRotation(crawler_leg4L, 0.5235988F, 0F, 0.7853982F);
      crawler_leg5L = new ModelRenderer(this, 0, 321);
      crawler_leg5L.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
      crawler_leg5L.setRotationPoint(2F, 7F, 11F);
      crawler_leg5L.setTextureSize(512, 512);
      crawler_leg5L.mirror = true;
      setRotation(crawler_leg5L, 0.5235988F, -0.7853982F, 0.7853982F);
      
      
      
      
      
      
      
      
      default_armL1 = new ModelRenderer(this, 0, 111);
      default_armL1.addBox(-2F, -3F, -3F, 6, 6, 6);
      default_armL1.setRotationPoint(7F, -3F, 1F);
      default_armL1.setTextureSize(512, 512);
      default_armL1.mirror = true;
      setRotation(default_armL1, 0F, 0F, -0.5235988F);
      default_armL2 = new ModelRenderer(this, 0, 124);
      default_armL2.addBox(-1F, 1F, -2F, 4, 5, 4);
      default_armL2.setRotationPoint(0F, 0F, 0F);
      default_armL2.setTextureSize(512, 512);
      default_armL2.mirror = true;
      setRotation(default_armL2, 0F, 0F, -0.0872665F + 0.5235988F);
      default_armL3 = new ModelRenderer(this, 0, 133);
      default_armL3.addBox(-1F, 5F, -1F, 5, 7, 5);
      default_armL3.setRotationPoint(0F, 0F, 0F);
      default_armL3.setTextureSize(512, 512);
      default_armL3.mirror = true;
      setRotation(default_armL3, -0.2617994F, 0F, 0.0872665F);
      default_armR1 = new ModelRenderer(this, 0, 111);
      default_armR1.mirror = true;
      default_armR1.addBox(-4F, -3F, -3F, 6, 6, 6);
      default_armR1.setRotationPoint(-7F, -3F, 1F);
      default_armR1.setTextureSize(512, 512);
      default_armR1.mirror = true;
      setRotation(default_armR1, 0F, 0F, 0.5235988F);
      default_armR1.mirror = false;
      default_armR2 = new ModelRenderer(this, 0, 124);
      default_armR2.mirror = true;
      default_armR2.addBox(-3F, 1F, -2F, 4, 5, 4);
      default_armR2.setRotationPoint(0F, 0F, 0F);
      default_armR2.setTextureSize(512, 512);
      default_armR2.mirror = true;
      setRotation(default_armR2, 0F, 0F, 0.0872665F - 0.5235988F);
      default_armR2.mirror = false;
      default_armR3 = new ModelRenderer(this, 0, 133);
      default_armR3.mirror = true;
      default_armR3.addBox(-4F, 5F, -1F, 5, 7, 5);
      default_armR3.setRotationPoint(0F, 0F, 0F);
      default_armR3.setTextureSize(512, 512);
      default_armR3.mirror = true;
      setRotation(default_armR3, -0.2617994F, 0F, 0F - 0.0872665F);
      default_armR3.mirror = false;
      
      golem_armor_sholderL = new ModelRenderer(this, 52, 51);
      golem_armor_sholderL.addBox(-3F, -4F, -3F, 9, 7, 9);
      golem_armor_sholderL.setRotationPoint(7F, -3F, 1F);
      golem_armor_sholderL.setTextureSize(512, 512);
      golem_armor_sholderL.mirror = true;
      setRotation(golem_armor_sholderL, 0F, 0F, 0F);
      golem_sholderL = new ModelRenderer(this, 52, 1);
      golem_sholderL.addBox(-2F, -3F, -2F, 7, 7, 7);
      golem_sholderL.setRotationPoint(7F, -3F, 1F);
      golem_sholderL.setTextureSize(512, 512);
      golem_sholderL.mirror = true;
      setRotation(golem_sholderL, 0F, 0F, 0F);
      golem_upper_armL = new ModelRenderer(this, 54, 17);
      golem_upper_armL.addBox(0F, 4F, 0F, 3, 9, 3);
      golem_upper_armL.setRotationPoint(7F, -3F, 1F);
      golem_upper_armL.setTextureSize(512, 512);
      golem_upper_armL.mirror = true;
      setRotation(golem_upper_armL, 0F, 0F, -0.2617994F);
      golem_lower_armL = new ModelRenderer(this, 52, 31);
      golem_lower_armL.addBox(-1F, 9F, -16F, 6, 7, 13);
      golem_lower_armL.setRotationPoint(7F, -3F, 1F);
      golem_lower_armL.setTextureSize(512, 512);
      golem_lower_armL.mirror = true;
      setRotation(golem_lower_armL, 0.5235988F, 0F, -0.2617994F);
      golem_armor_lower_armL = new ModelRenderer(this, 64, 75);
      golem_armor_lower_armL.addBox(-1.5F, 8.5F, -16.5F, 7, 8, 14);
      golem_armor_lower_armL.setRotationPoint(7F, -3F, 1F);
      golem_armor_lower_armL.setTextureSize(512, 512);
      golem_armor_lower_armL.mirror = true;
      setRotation(golem_armor_lower_armL, 0.5235988F, 0F, -0.2617994F);
      golem_armor_sholderR = new ModelRenderer(this, 52, 51);
      golem_armor_sholderR.mirror = true;
      golem_armor_sholderR.addBox(-6F, -4F, -3F, 9, 7, 9);
      golem_armor_sholderR.setRotationPoint(-7F, -3F, 1F);
      golem_armor_sholderR.setTextureSize(512, 512);
      golem_armor_sholderR.mirror = true;
      setRotation(golem_armor_sholderR, 0F, 0F, 0F);
      golem_armor_sholderR.mirror = false;
      golem_sholderR = new ModelRenderer(this, 52, 1);
      golem_sholderR.mirror = true;
      golem_sholderR.addBox(-5F, -3F, -2F, 7, 7, 7);
      golem_sholderR.setRotationPoint(-7F, -3F, 1F);
      golem_sholderR.setTextureSize(512, 512);
      golem_sholderR.mirror = true;
      setRotation(golem_sholderR, 0F, 0F, 0F);
      golem_sholderR.mirror = false;
      golem_upper_armR = new ModelRenderer(this, 54, 17);
      golem_upper_armR.mirror = true;
      golem_upper_armR.addBox(-3F, 4F, 0F, 3, 9, 3);
      golem_upper_armR.setRotationPoint(-7F, -3F, 1F);
      golem_upper_armR.setTextureSize(512, 512);
      golem_upper_armR.mirror = true;
      setRotation(golem_upper_armR, 0F, 0F, 0.2617994F);
      golem_upper_armR.mirror = false;
      golem_lower_armR = new ModelRenderer(this, 52, 31);
      golem_lower_armR.mirror = true;
      golem_lower_armR.addBox(-5F, 9F, -16F, 6, 7, 13);
      golem_lower_armR.setRotationPoint(-7F, -3F, 1F);
      golem_lower_armR.setTextureSize(512, 512);
      golem_lower_armR.mirror = true;
      setRotation(golem_lower_armR, 0.5235988F, 0F, 0.2617994F);
      golem_lower_armR.mirror = false;
      golem_armor_lower_armR = new ModelRenderer(this, 64, 75);
      golem_armor_lower_armR.mirror = true;
      golem_armor_lower_armR.addBox(-5.5F, 8.5F, -16.5F, 7, 8, 14);
      golem_armor_lower_armR.setRotationPoint(-7F, -3F, 1F);
      golem_armor_lower_armR.setTextureSize(512, 512);
      golem_armor_lower_armR.mirror = true;
      setRotation(golem_armor_lower_armR, 0.5235988F, 0F, 0.2617994F);
      golem_armor_lower_armR.mirror = false;

      upper_claw_armL = new ModelRenderer(this, 132, 0);
      upper_claw_armL.addBox(-1F, -2F, -1F, 9, 3, 3);
      upper_claw_armL.setRotationPoint(6F, -3F, 1F);
      upper_claw_armL.setTextureSize(512, 512);
      upper_claw_armL.mirror = true;
      setRotation(upper_claw_armL, 0F, 0.2617994F, 0.5235988F);
      lower_claw_armL = new ModelRenderer(this, 132, 6);
      lower_claw_armL.addBox(6F, 0F, -13F, 4, 4, 11);
      lower_claw_armL.setRotationPoint(6F, -3F, 1F);
      lower_claw_armL.setTextureSize(512, 512);
      lower_claw_armL.mirror = true;
      setRotation(lower_claw_armL, 0.5235988F, 0F, 0F);
      clawarmclaw1L = new ModelRenderer(this, 132, 21);
      clawarmclaw1L.addBox(7F, 0.5F, -21F, 5, 3, 12);
      clawarmclaw1L.setRotationPoint(6F, -3F, 1F);
      clawarmclaw1L.setTextureSize(512, 512);
      clawarmclaw1L.mirror = true;
      setRotation(clawarmclaw1L, 0.5235988F, 0F, 0F);
      clawarmclaw2L = new ModelRenderer(this, 132, 36);
      clawarmclaw2L.addBox(11.1F, 0F, -14F, 3, 2, 7);
      clawarmclaw2L.setRotationPoint(6F, -3F, 1F);
      clawarmclaw2L.setTextureSize(512, 512);
      clawarmclaw2L.mirror = true;
      setRotation(clawarmclaw2L, 0.5235988F, 0.418879F, 0.2792527F);
      upper_claw_armR = new ModelRenderer(this, 132, 0);
      upper_claw_armR.mirror = true;
      upper_claw_armR.addBox(-8F, -2F, -1F, 9, 3, 3);
      upper_claw_armR.setRotationPoint(-6F, -3F, 1F);
      upper_claw_armR.setTextureSize(512, 512);
      upper_claw_armR.mirror = true;
      setRotation(upper_claw_armR, 0F, -0.2617994F, -0.5235988F);
      upper_claw_armR.mirror = false;
      lower_claw_armR = new ModelRenderer(this, 132, 6);
      lower_claw_armR.mirror = true;
      lower_claw_armR.addBox(-10F, 0F, -13F, 4, 4, 11);
      lower_claw_armR.setRotationPoint(-6F, -3F, 1F);
      lower_claw_armR.setTextureSize(512, 512);
      lower_claw_armR.mirror = true;
      setRotation(lower_claw_armR, 0.5235988F, 0F, 0F);
      lower_claw_armR.mirror = false;
      clawarmclaw1R = new ModelRenderer(this, 132, 21);
      clawarmclaw1R.mirror = true;
      clawarmclaw1R.addBox(-12F, 0.5F, -21F, 5, 3, 12);
      clawarmclaw1R.setRotationPoint(-6F, -3F, 1F);
      clawarmclaw1R.setTextureSize(512, 512);
      clawarmclaw1R.mirror = true;
      setRotation(clawarmclaw1R, 0.5235988F, 0F, 0F);
      clawarmclaw1R.mirror = false;
      clawarmclaw2R = new ModelRenderer(this, 132, 36);
      clawarmclaw2R.mirror = true;
      clawarmclaw2R.addBox(-14.1F, 0F, -14F, 3, 2, 7);
      clawarmclaw2R.setRotationPoint(-6F, -3F, 1F);
      clawarmclaw2R.setTextureSize(512, 512);
      clawarmclaw2R.mirror = true;
      setRotation(clawarmclaw2R, 0.5235988F, -0.418879F, -0.2792527F);
      clawarmclaw2R.mirror = false;

      bug_lower_arm1L = new ModelRenderer(this, 167, 0);
      bug_lower_arm1L.addBox(-1.5F, -2F, -1.5F, 3, 7, 3);
      bug_lower_arm1L.setRotationPoint(7F, 2F, 1F);
      bug_lower_arm1L.setTextureSize(512, 512);
      bug_lower_arm1L.mirror = true;
      setRotation(bug_lower_arm1L, -0.2617994F, 0F, -0.7853982F);
      bug_lower_arm2L = new ModelRenderer(this, 167, 15);
      bug_lower_arm2L.addBox(2F, 3F, -1.5F, 2, 8, 2);
      bug_lower_arm2L.setRotationPoint(7F, 2F, 1F);
      bug_lower_arm2L.setTextureSize(512, 512);
      bug_lower_arm2L.mirror = true;
      setRotation(bug_lower_arm2L, -0.2617994F, 0F, 0F);
      bug_upper_arm1L = new ModelRenderer(this, 167, 0);
      bug_upper_arm1L.addBox(-1.5F, -2F, -1.5F, 3, 7, 3);
      bug_upper_arm1L.setRotationPoint(7F, -3F, 1F);
      bug_upper_arm1L.setTextureSize(512, 512);
      bug_upper_arm1L.mirror = true;
      setRotation(bug_upper_arm1L, -0.5235988F, 0F, -0.7853982F);
      bug_upper_arm2L = new ModelRenderer(this, 167, 15);
      bug_upper_arm2L.addBox(2F, 3F, -2F, 2, 8, 2);
      bug_upper_arm2L.setRotationPoint(7F, -3F, 1F);
      bug_upper_arm2L.setTextureSize(512, 512);
      bug_upper_arm2L.mirror = true;
      setRotation(bug_upper_arm2L, -0.5235988F, 0F, 0F);
      bug_lower_handL = new ModelRenderer(this, 167, 29);
      bug_lower_handL.addBox(1.5F, 11F, -2.5F, 3, 4, 3);
      bug_lower_handL.setRotationPoint(7F, 2F, 1F);
      bug_lower_handL.setTextureSize(512, 512);
      bug_lower_handL.mirror = true;
      setRotation(bug_lower_handL, -0.2617994F, 0F, 0F);
      bug_upper_handL = new ModelRenderer(this, 167, 29);
      bug_upper_handL.addBox(1.5F, 11F, -2.5F, 3, 4, 3);
      bug_upper_handL.setRotationPoint(7F, -3F, 1F);
      bug_upper_handL.setTextureSize(512, 512);
      bug_upper_handL.mirror = true;
      setRotation(bug_upper_handL, -0.5235988F, 0F, 0F);
      bug_lower_arm1R = new ModelRenderer(this, 167, 0);
      bug_lower_arm1R.mirror = true;
      bug_lower_arm1R.addBox(-1.5F, -2F, -1.5F, 3, 7, 3);
      bug_lower_arm1R.setRotationPoint(-7F, 2F, 1F);
      bug_lower_arm1R.setTextureSize(512, 512);
      bug_lower_arm1R.mirror = true;
      setRotation(bug_lower_arm1R, -0.2617994F, 0F, 0.7853982F);
      bug_lower_arm1R.mirror = false;
      bug_lower_arm2R = new ModelRenderer(this, 167, 15);
      bug_lower_arm2R.mirror = true;
      bug_lower_arm2R.addBox(-4F, 3F, -1.5F, 2, 8, 2);
      bug_lower_arm2R.setRotationPoint(-7F, 2F, 1F);
      bug_lower_arm2R.setTextureSize(512, 512);
      bug_lower_arm2R.mirror = true;
      setRotation(bug_lower_arm2R, -0.2617994F, 0F, 0F);
      bug_lower_arm2R.mirror = false;
      bug_upper_arm1R = new ModelRenderer(this, 167, 0);
      bug_upper_arm1R.mirror = true;
      bug_upper_arm1R.addBox(-1.5F, -2F, -1.5F, 3, 7, 3);
      bug_upper_arm1R.setRotationPoint(-7F, -3F, 1F);
      bug_upper_arm1R.setTextureSize(512, 512);
      bug_upper_arm1R.mirror = true;
      setRotation(bug_upper_arm1R, -0.5235988F, 0F, 0.7853982F);
      bug_upper_arm1R.mirror = false;
      bug_upper_arm2R = new ModelRenderer(this, 167, 15);
      bug_upper_arm2R.mirror = true;
      bug_upper_arm2R.addBox(-4F, 3F, -2F, 2, 8, 2);
      bug_upper_arm2R.setRotationPoint(-7F, -3F, 1F);
      bug_upper_arm2R.setTextureSize(512, 512);
      bug_upper_arm2R.mirror = true;
      setRotation(bug_upper_arm2R, -0.5235988F, 0F, 0F);
      bug_upper_arm2R.mirror = false;
      bug_lower_handR = new ModelRenderer(this, 167, 29);
      bug_lower_handR.mirror = true;
      bug_lower_handR.addBox(-4.5F, 11F, -2.5F, 3, 4, 3);
      bug_lower_handR.setRotationPoint(-7F, 2F, 1F);
      bug_lower_handR.setTextureSize(512, 512);
      bug_lower_handR.mirror = true;
      setRotation(bug_lower_handR, -0.2617994F, 0F, 0F);
      bug_lower_handR.mirror = false;
      bug_upper_handR = new ModelRenderer(this, 167, 29);
      bug_upper_handR.mirror = true;
      bug_upper_handR.addBox(-4.5F, 11F, -2.5F, 3, 4, 3);
      bug_upper_handR.setRotationPoint(-7F, -3F, 1F);
      bug_upper_handR.setTextureSize(512, 512);
      bug_upper_handR.mirror = true;
      setRotation(bug_upper_handR, -0.5235988F, 0F, 0F);
      bug_upper_handR.mirror = false;

      
      
      
      
      
     
      default_tail1 = new ModelRenderer(this, 0, 90);
      default_tail1.addBox(-3F, -2F, -2F, 6, 5, 3);
      default_tail1.setRotationPoint(0F, 8F, 6F);
      default_tail1.setTextureSize(512, 512);
      default_tail1.mirror = true;
      setRotation(default_tail1, -0.5235988F, 0F, 0F);
      default_tail2 = new ModelRenderer(this, 0, 99);
      default_tail2.addBox(-2F, -1F, 0F, 4, 3, 3);
      default_tail2.setRotationPoint(0F, 0F, 0F);
      default_tail2.setTextureSize(512, 512);
      default_tail2.mirror = true;
      setRotation(default_tail2, -0.2617994F + 0.5235988F, 0F, 0F);
      default_tail3 = new ModelRenderer(this, 0, 106);
      default_tail3.addBox(-1.5F, 0.5F, 2F, 3, 2, 2);
      default_tail3.setRotationPoint(0F, 0F, 0F);
      default_tail3.setTextureSize(512, 512);
      default_tail3.mirror = true;
      setRotation(default_tail3, 0.2617994F, 0F, 0F);
      
      wolf_tail_1 = new ModelRenderer(this, 400, 251);
      wolf_tail_1.addBox(-1.5F, 0F, -1.5F, 3, 3, 3);
      wolf_tail_1.setRotationPoint(0F, 8F, 4F);
      wolf_tail_1.setTextureSize(512, 512);
      wolf_tail_1.mirror = true;
      setRotation(wolf_tail_1, 1.134464F, 0F, 0F);
      wolf_tail_2 = new ModelRenderer(this, 400, 257);
      wolf_tail_2.addBox(-2F, 3F, -2F, 4, 4, 4);
      wolf_tail_2.setRotationPoint(0F, 0F, 0F);
      wolf_tail_2.setTextureSize(512, 512);
      wolf_tail_2.mirror = true;
      setRotation(wolf_tail_2, 0F, 0F, 0F);
      wolf_tail_3 = new ModelRenderer(this, 400, 265);
      wolf_tail_3.addBox(-2.5F, 7F, -2.5F, 5, 4, 5);
      wolf_tail_3.setRotationPoint(0F, 0F, 0F);
      wolf_tail_3.setTextureSize(512, 512);
      wolf_tail_3.mirror = true;
      setRotation(wolf_tail_3, 0F, 0F, 0F);
      wolf_tail_4 = new ModelRenderer(this, 400, 273);
      wolf_tail_4.addBox(-2F, 10F, -2F, 4, 4, 4);
      wolf_tail_4.setRotationPoint(0F, 0F, 0F);
      wolf_tail_4.setTextureSize(512, 512);
      wolf_tail_4.mirror = true;
      setRotation(wolf_tail_4, 0F, 0F, 0F);
      wolf_tail_5 = new ModelRenderer(this, 400, 282);
      wolf_tail_5.addBox(-1.5F, 14F, -1.5F, 3, 2, 3);
      wolf_tail_5.setRotationPoint(0F, 0F, 0F);
      wolf_tail_5.setTextureSize(512, 512);
      wolf_tail_5.mirror = true;
      setRotation(wolf_tail_5, 0F, 0F, 0F);
      wolf_tail_6 = new ModelRenderer(this, 400, 288);
      wolf_tail_6.addBox(-1F, 16F, -1F, 2, 1, 2);
      wolf_tail_6.setRotationPoint(0F, 0F, 0F);
      wolf_tail_6.setTextureSize(512, 512);
      wolf_tail_6.mirror = true;
      setRotation(wolf_tail_6, 0F, 0F, 0F);

      shark_tail_1 = new ModelRenderer(this, 400, 163);
      shark_tail_1.addBox(-3F, -3F, -3F, 6, 6, 7);
      shark_tail_1.setRotationPoint(0F, 8F, 6F);
      shark_tail_1.setTextureSize(512, 512);
      shark_tail_1.mirror = true;
      setRotation(shark_tail_1, -0.2617994F, 0F, 0F);
      shark_tail_2 = new ModelRenderer(this, 400, 178);
      shark_tail_2.addBox(-2.5F, -3.5F, 0F, 5, 5, 7);
      shark_tail_2.setRotationPoint(0F, 1F, 3F);
      shark_tail_2.setTextureSize(512, 512);
      shark_tail_2.mirror = true;
      setRotation(shark_tail_2, 0.1047198F, 0F, 0F);
      shark_tail_3 = new ModelRenderer(this, 400, 192);
      shark_tail_3.addBox(-2F, -3F, 0F, 4, 4, 7);
      shark_tail_3.setRotationPoint(0F, 0F, 6F);
      shark_tail_3.setTextureSize(512, 512);
      shark_tail_3.mirror = true;
      setRotation(shark_tail_3, 0.1047197F, 0F, 0F);
      shark_tail_4 = new ModelRenderer(this, 400, 206);
      shark_tail_4.addBox(-0.5F, -2F, -1F, 1, 13, 17);
      shark_tail_4.setRotationPoint(0F, 0F, 6F);
      shark_tail_4.setTextureSize(512, 512);
      shark_tail_4.mirror = true;
      setRotation(shark_tail_4, 0.9948377F, 0F, 0F);
      shark_tail_fin = new ModelRenderer(this, 400, 238);
      shark_tail_fin.addBox(-0.5F, -3F, 1F, 1, 6, 7);
      shark_tail_fin.setRotationPoint(0F, 0F, 0F);
      shark_tail_fin.setTextureSize(512, 512);
      shark_tail_fin.mirror = true;
      setRotation(shark_tail_fin, 1.0471976F, 0F, 0F);
      shark_finsideR = new ModelRenderer(this, 420, 238);
      shark_finsideR.mirror = true;
      shark_finsideR.addBox(-1.5F, -2.5F, 2F, 1, 3, 4);
      shark_finsideR.setRotationPoint(0F, 1F, 0F);
      shark_finsideR.setTextureSize(512, 512);
      shark_finsideR.mirror = true;
      setRotation(shark_finsideR, -0.6283186F, 0F, 0.5235988F);
      shark_finsideR.mirror = false;
      shark_finsideL = new ModelRenderer(this, 420, 238);
      shark_finsideL.addBox(0.5F, -2.5F, 2F, 1, 3, 4);
      shark_finsideL.setRotationPoint(0F, 1F, 0F);
      shark_finsideL.setTextureSize(512, 512);
      shark_finsideL.mirror = true;
      setRotation(shark_finsideL, -0.6283186F, 0F, -0.5235988F);
      
      
      scorpion_tail1 = new ModelRenderer(this, 400, 292);
      scorpion_tail1.addBox(-2F, -2F, 0F, 4, 4, 4);
      scorpion_tail1.setRotationPoint(0F, 8F, 5F);
      scorpion_tail1.setTextureSize(512, 512);
      scorpion_tail1.mirror = true;
      setRotation(scorpion_tail1, 0F, 0F, 0F);
      scorpion_tail2 = new ModelRenderer(this, 400, 292);
      scorpion_tail2.addBox(-2F, -2F, 0F, 4, 4, 4);
      scorpion_tail2.setRotationPoint(0F, -1F, 4F);
      scorpion_tail2.setTextureSize(512, 512);
      scorpion_tail2.mirror = true;
      setRotation(scorpion_tail2, 0F, 0F, 0F);
      scorpion_tail3 = new ModelRenderer(this, 400, 292);
      scorpion_tail3.addBox(-2F, -2F, 0F, 4, 4, 4);
      scorpion_tail3.setRotationPoint(0F, -2F, 3.5F);
      scorpion_tail3.setTextureSize(512, 512);
      scorpion_tail3.mirror = true;
      setRotation(scorpion_tail3, 0F, 0F, 0F);
      scorpion_tail4 = new ModelRenderer(this, 400, 292);
      scorpion_tail4.addBox(-2F, -2F, 0F, 4, 4, 4);
      scorpion_tail4.setRotationPoint(0F, -3F, 2.5F);
      scorpion_tail4.setTextureSize(512, 512);
      scorpion_tail4.mirror = true;
      setRotation(scorpion_tail4, 0F, 0F, 0F);
      scorpion_tail5 = new ModelRenderer(this, 400, 292);
      scorpion_tail5.addBox(-2F, -2F, 0F, 4, 4, 4);
      scorpion_tail5.setRotationPoint(0F, -3F, 2F);
      scorpion_tail5.setTextureSize(512, 512);
      scorpion_tail5.mirror = true;
      setRotation(scorpion_tail5, 0F, 0F, 0F);
      scorpion_tail6 = new ModelRenderer(this, 400, 292);
      scorpion_tail6.addBox(-2F, -2F, 0F, 4, 4, 4);
      scorpion_tail6.setRotationPoint(0F, -4F, 1F);
      scorpion_tail6.setTextureSize(512, 512);
      scorpion_tail6.mirror = true;
      setRotation(scorpion_tail6, 0F, 0F, 0F);
      scorpion_tail7 = new ModelRenderer(this, 400, 292);
      scorpion_tail7.addBox(-2F, -2F, 0F, 4, 4, 4);
      scorpion_tail7.setRotationPoint(0F, -4F, 1F);
      scorpion_tail7.setTextureSize(512, 512);
      scorpion_tail7.mirror = true;
      setRotation(scorpion_tail7, 0F, 0F, 0F);
      scorpion_tail8 = new ModelRenderer(this, 400, 292);
      scorpion_tail8.addBox(-2F, -2F, 0F, 4, 4, 4);
      scorpion_tail8.setRotationPoint(0F, -4F, -1F);
      scorpion_tail8.setTextureSize(512, 512);
      scorpion_tail8.mirror = true;
      setRotation(scorpion_tail8, 0F, 0F, 0F);
      scorpion_tail9 = new ModelRenderer(this, 400, 292);
      scorpion_tail9.addBox(-2F, -2F, 0F, 4, 4, 4);
      scorpion_tail9.setRotationPoint(0F, -4F, -2F);
      scorpion_tail9.setTextureSize(512, 512);
      scorpion_tail9.mirror = true;
      setRotation(scorpion_tail9, 0F, 0F, 0F);
      scorpion_stinger1 = new ModelRenderer(this, 400, 300);
      scorpion_stinger1.addBox(-2.5F, -7F, -2F, 5, 7, 5);
      scorpion_stinger1.setRotationPoint(0F, -3F, 1F);
      scorpion_stinger1.setTextureSize(512, 512);
      scorpion_stinger1.mirror = true;
      setRotation(scorpion_stinger1, 2.059489F, 0F, 0F);
      scorpion_stinger2 = new ModelRenderer(this, 400, 312);
      scorpion_stinger2.addBox(-1.5F, -11F, -1F, 3, 4, 3);
      scorpion_stinger2.setRotationPoint(0F, 0F, 0F);
      scorpion_stinger2.setTextureSize(512, 512);
      scorpion_stinger2.mirror = true;
      setRotation(scorpion_stinger2, 0F, 0F, 0F);
      scorpion_stinger3 = new ModelRenderer(this, 399, 312);
      scorpion_stinger3.addBox(-0.5F, -13F, 0F, 1, 2, 1);
      scorpion_stinger3.setRotationPoint(0F, 0F, 0F);
      scorpion_stinger3.setTextureSize(512, 512);
      scorpion_stinger3.mirror = true;
      setRotation(scorpion_stinger3, 0F, 0F, 0F);


      
      
      
      
      default_wing_stubR = new ModelRenderer(this, 18, 49);
      default_wing_stubR.mirror = true;
      default_wing_stubR.addBox(-1F, -2F, 0F, 2, 4, 1);
      default_wing_stubR.setRotationPoint(-3F, -3F, 4F);
      default_wing_stubR.setTextureSize(512, 512);
      default_wing_stubR.mirror = true;
      setRotation(default_wing_stubR, 0.2617994F, 0F, 0F);
      default_wing_stubR.mirror = false;
      default_wing_stubL = new ModelRenderer(this, 18, 49);
      default_wing_stubL.addBox(-1F, -2F, 0F, 2, 4, 1);
      default_wing_stubL.setRotationPoint(3F, -3F, 4F);
      default_wing_stubL.setTextureSize(512, 512);
      default_wing_stubL.mirror = true;
      setRotation(default_wing_stubL, 0.2617994F, 0F, 0F);
      
      
      
      
      default_armL1.addChild(default_armL2);
      default_armL2.addChild(default_armL3);
      default_armR1.addChild(default_armR2);
      default_armR2.addChild(default_armR3);
      
      default_legL1.addChild(default_legL2);
      default_legL2.addChild(default_legL3);
      default_legL3.addChild(default_legL4);
      default_legL3.addChild(default_legL5);
      default_legR1.addChild(default_legR2);
      default_legR2.addChild(default_legR3);
      default_legR3.addChild(default_legR4);
      default_legR3.addChild(default_legR5);
      
      default_tail1.addChild(default_tail2);
      default_tail2.addChild(default_tail3);
      
      
      
      jumper_leg1L.addChild(jumper_leg2L);
      jumper_leg2L.addChild(jumper_leg3L);
      jumper_leg3L.addChild(jumper_footL);
      jumper_leg1R.addChild(jumper_leg2R);
      jumper_leg2R.addChild(jumper_leg3R);
      jumper_leg3R.addChild(jumper_footR);
      
      
      heavy_leg_1L.addChild(heavy_leg_2L);
      heavy_leg_1R.addChild(heavy_leg_2R);
      
      crawler_torso2.addChild(lower_crawler_torso1);
      lower_crawler_torso1.addChild(lower_crawler_torso2);
      lower_crawler_torso2.addChild(lower_crawler_torso3);
      lower_crawler_torso3.addChild(crawler_tail1);
      crawler_tail1.addChild(crawler_tail2);
      
      lower_crawler_torso3.addChild(crawler_leg5L);
      lower_crawler_torso3.addChild(crawler_leg5R);
      lower_crawler_torso3.addChild(crawler_leg4L);
      lower_crawler_torso3.addChild(crawler_leg4R);
      lower_crawler_torso2.addChild(crawler_leg3L);
      lower_crawler_torso2.addChild(crawler_leg3R);
      lower_crawler_torso1.addChild(crawler_leg2TL);
      lower_crawler_torso1.addChild(crawler_leg2TR);
      crawler_leg2TL.addChild(crawler_leg2BL);
      crawler_leg2TR.addChild(crawler_leg2BR);
      crawler_torso2.addChild(crawler_leg1TL);
      crawler_torso2.addChild(crawler_leg1TR);
      crawler_leg1TL.addChild(crawler_leg1BL);
      crawler_leg1TR.addChild(crawler_leg1BR);
      
      wolf_tail_1.addChild(wolf_tail_2);
      wolf_tail_2.addChild(wolf_tail_3);
      wolf_tail_3.addChild(wolf_tail_4);
      wolf_tail_4.addChild(wolf_tail_5);
      wolf_tail_5.addChild(wolf_tail_6);
      
      shark_tail_1.addChild(shark_tail_2);
      shark_tail_2.addChild(shark_tail_3);
      shark_tail_3.addChild(shark_tail_4);
      shark_tail_1.addChild(shark_tail_fin);
      shark_tail_2.addChild(shark_finsideL);
      shark_tail_2.addChild(shark_finsideR);
      
      
      spitter_head.addChild(spitter_head_eyeL);
      spitter_head.addChild(spitter_head_eyeR);
      spitter_head.addChild(spitter_head_jaws);
      
      this.bipedHead.addChild(hornhead_1);
      hornhead_1.addChild(hornhead2);
      hornhead_1.addChild(hornhead3);
      hornhead_1.addChild(hornhead_4);
      hornhead_1.addChild(hornhead_hornL);
      hornhead_1.addChild(hornhead_hornR);
      hornhead_1.addChild(hornhead_jaw);
      
      hard_head.addChild(hard_head_face);
      hard_head.addChild(hard_head_fin);
      hard_head.addChild(hard_head_jaw);
      hard_head.addChild(hard_head_sideL);
      hard_head.addChild(hard_head_side_R);
      hard_head.addChild(hard_head_top);
      
      scorpion_tail1.addChild(scorpion_tail2);
      scorpion_tail2.addChild(scorpion_tail3);
      scorpion_tail3.addChild(scorpion_tail4);
      scorpion_tail4.addChild(scorpion_tail5);
      scorpion_tail5.addChild(scorpion_tail6);
      scorpion_tail6.addChild(scorpion_tail7);
      scorpion_tail7.addChild(scorpion_tail8);
      scorpion_tail8.addChild(scorpion_tail9);
      scorpion_tail9.addChild(scorpion_stinger1);
      scorpion_stinger1.addChild(scorpion_stinger2);
      scorpion_stinger2.addChild(scorpion_stinger3);
      
      
      
  }
  
  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
		super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    
    if(entity instanceof EntityPlayer)
    {
    	EntityPlayer player = (EntityPlayer)entity;
    	ExtendedPlayer props = ExtendedPlayer.get(player);
		default_torso.render(f5);
    	if(props.getFaction() == 3)
    	{
    	if(props.getHead() == 0)
    	{
    		default_head.render(f5);
    		default_neck.render(f5);
    	}
    	if(props.getHead() == 1)
    	{
    		spitter_head.render(f5);
    	}
     	if(props.getHead() == 2)
    	{
    		hornhead_1.render(f5);
    	}
    	if(props.getHead() == 3)
    	{
    		hard_head.render(f5);
    	}
    	if(props.getBack() == 0)
    	{
    		default_wing_stubR.render(f5);
    		default_wing_stubL.render(f5);
    	}
    	if(props.getBack() == 1)
    	{
    		armored_backTR.render(f5);
        	armored_backneck.render(f5);
        	armored_back_BR.render(f5);
        	armored_backTL.render(f5);
        	armored_back_BL.render(f5);
    	}
    	if(props.getBack() == 2)
    	{
    		spike3R.render(f5);
    	    spike1R.render(f5);
    	    spike2R.render(f5);
    	    spike1L.render(f5);
    	    spike2L.render(f5);
    	    spike3L.render(f5);
    	}
    	if(props.getBack() == 3)
    	{
    		bugwing_R.render(f5);
    	    bugwing_L.render(f5);
    	}
    	if(props.getLegs() == 0)
    	{
    		Default_lowertorso.render(f5);
    		default_legL1.render(f5);
    		default_legR1.render(f5);
    	}
    	if(props.getLegs() == 1)
    	{
    		jumper_torso1.render(f5);
    	    jumper_torso2.render(f5);
    	    jumper_leg1R.render(f5);
    	    jumper_leg1L.render(f5);
    	}
    	if(props.getLegs() == 2)
    	{
    		heavy_lower_torso2.render(f5);
    	    heavy_lower_torso1.render(f5);
    	    heavy_leg_1R.render(f5);
    	    heavy_leg_1L.render(f5);
    	}
    	if(props.getLegs() == 3)
    	{
    		crawler_torso1.render(f5);
    	    crawler_torso2.render(f5);
    	}
    	if(props.getArms() == 0)
    	{
    		default_armL1.render(f5);
    		default_armR1.render(f5);
    	}
    	if(props.getArms() == 1)
    	{
    		golem_armor_sholderL.render(f5);
    	    golem_sholderL.render(f5);
    	    golem_upper_armL.render(f5);
    	    golem_lower_armL.render(f5);
    	    golem_armor_lower_armL.render(f5);
    	    golem_armor_sholderR.render(f5);
    	    golem_sholderR.render(f5);
    	    golem_upper_armR.render(f5);
    	    golem_lower_armR.render(f5);
    	    golem_armor_lower_armR.render(f5);
    	}
    	if(props.getArms() == 2)
    	{
    		 upper_claw_armL.render(f5);
    		    lower_claw_armL.render(f5);
    		    clawarmclaw1L.render(f5);
    		    clawarmclaw2L.render(f5);
    		    upper_claw_armR.render(f5);
    		    lower_claw_armR.render(f5);
    		    clawarmclaw1R.render(f5);
    		    clawarmclaw2R.render(f5);
    	}
    	if(props.getArms() == 3)
    	{
    		 bug_lower_arm1L.render(f5);
    		    bug_lower_arm2L.render(f5);
    		    bug_upper_arm1L.render(f5);
    		    bug_upper_arm2L.render(f5);
    		    bug_lower_handL.render(f5);
    		    bug_upper_handL.render(f5);
    		    bug_lower_arm1R.render(f5);
    		    bug_lower_arm2R.render(f5);
    		    bug_upper_arm1R.render(f5);
    		    bug_upper_arm2R.render(f5);
    		    bug_lower_handR.render(f5);
    		    bug_upper_handR.render(f5);
    	}
    	if(props.getTail() == 0 && props.getLegs() != 3)
    	{
        	default_tail1.render(f5);
    	}
    	if(props.getTail() == 1 && props.getLegs() != 3)
    	{
    		wolf_tail_1.render(f5);
    	}
    	if(props.getTail() == 2 && props.getLegs() != 3)
    	{
    		shark_tail_1.render(f5);
    	}
    	if(props.getTail() == 3 && props.getLegs() != 3)
    	{
    	    scorpion_tail1.render(f5);
    	 }
    	}
    	
    	else
    	{
    		this.bipedBody.render(f5);
    		this.bipedEars.render(f5);
    		this.bipedCloak.render(f5);
    		this.bipedHead.render(f5);
    		this.bipedHeadwear.render(f5);
    		this.bipedLeftArm.render(f5);
    		this.bipedLeftLeg.render(f5);
    		this.bipedRightArm.render(f5);
    		this.bipedRightLeg.render(f5);
    	}
    	
    	

    	
    }
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  @Override
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {

    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    if(entity instanceof EntityPlayer)
    {

    	EntityPlayer player = (EntityPlayer)entity;
    	
    	this.bipedBody.showModel = false;
    	this.bipedCloak.showModel = false;
    	this.bipedEars.showModel = false;
    	this.bipedHead.showModel = false;
    	this.bipedHeadwear.showModel = false;
    	this.bipedLeftArm.showModel = false;
    	this.bipedLeftLeg.showModel = false;
    	this.bipedRightArm.showModel = false;
    	this.bipedRightLeg.showModel = false;
    	
    	
    	this.default_head.rotateAngleY = f3 / (180F / (float)Math.PI);
    	this.default_head.rotateAngleX = f4 / (180F / (float)Math.PI);

    	this.spitter_head.rotateAngleY = f3 / (180F / (float)Math.PI);
    	this.spitter_head.rotateAngleX = f4 / (180F / (float)Math.PI) + 0.5235988F;

    	this.hornhead_1.rotateAngleY = f3 / (180F / (float)Math.PI);
    	this.hornhead_1.rotateAngleX = f4 / (180F / (float)Math.PI) + 0.2617994F;

    	this.hard_head.rotateAngleY = f3 / (180F / (float)Math.PI);
    	this.hard_head.rotateAngleX = f4 / (180F / (float)Math.PI);
    
    	
    	this.default_armL1.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.6F * f1;
    	this.default_armR1.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.6F * f1;
    	this.default_armL2.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * f1 * 0.5F;
    	this.default_armR2.rotateAngleX = MathHelper.cos(f * 0.3662F) * f1 * 0.5F;
    
    	if(player.motionX == 0 && player.motionZ == 0)
        {
        	this.wolf_tail_1.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) );
        	this.wolf_tail_2.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
        	this.wolf_tail_3.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
        	this.wolf_tail_4.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
        	this.wolf_tail_5.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
        	this.wolf_tail_6.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
        	
        	this.wolf_tail_1.rotateAngleX = 0.834464F;
        }
    	else
    	{
    		this.wolf_tail_1.rotateAngleZ = 0;
    		this.wolf_tail_2.rotateAngleZ = 0;
    		this.wolf_tail_3.rotateAngleZ = 0;
    		this.wolf_tail_4.rotateAngleZ = 0;
    		this.wolf_tail_5.rotateAngleZ = 0;
    		this.wolf_tail_6.rotateAngleZ = 0;

    		this.wolf_tail_1.rotateAngleX = MathHelper.sin(f * 0.3662F) * 0.1F * f1 + 1.134464F;
    		this.wolf_tail_2.rotateAngleX = MathHelper.sin(f * 0.3662F) * 0.1F * f1;
    		this.wolf_tail_3.rotateAngleX = MathHelper.sin(f * 0.3662F) * 0.1F * f1;
    		this.wolf_tail_4.rotateAngleX = MathHelper.sin(f * 0.3662F) * 0.07F * f1;
    		this.wolf_tail_5.rotateAngleX = MathHelper.sin(f * 0.3662F) * 0.05F * f1;
    		this.wolf_tail_6.rotateAngleX = MathHelper.sin(f * 0.3662F) * 0.05F * f1;
    		
    		
    	}
    	
    	if(player.isSneaking())
    	{
    		this.default_torso.rotateAngleX = 0.47F;
    		this.Default_lowertorso.rotateAngleX = 0.15F;
    		this.default_tail1.rotateAngleX = -0.4F;
    		this.default_neck.rotateAngleX = 0.4017994F;
    		this.default_armL1.rotationPointY = -2.0F;
    		this.default_armR1.rotationPointY = -2.0F;
    		this.default_armL1.rotationPointZ = -1.0F;
    		this.default_armR1.rotationPointZ = -1.0F;
    		this.default_head.rotationPointY = -6.5F;
    		this.default_head.rotationPointZ = -2.0F;
    		this.default_wing_stubR.rotationPointY = -2.0F;
    		this.default_wing_stubL.rotationPointY = -2.0F;
    		this.default_wing_stubR.rotationPointZ = 2.0F;
    		this.default_wing_stubL.rotationPointZ = 2.0F;
    		this.default_legR1.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.6F * f1 -0.7235988F;
    		this.default_legL1.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.6F * f1 -0.7235988F;
    		this.default_legR2.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.3F * f1 + 0.2617994F + 0.9235988F;
    		this.default_legL2.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.3F * f1 + 0.2617994F + 0.9235988F;
    		this.default_legL2.rotationPointZ = -1.5F;
    		this.default_legR2.rotationPointZ = -1.5F;

    		this.spitter_head.rotationPointY = -6F;
    		this.spitter_head.rotationPointZ = -2.0F;

    		this.hornhead_1.rotationPointY = -6F;
    		this.hornhead_1.rotationPointZ = -2.0F;

    		this.hard_head.rotationPointY = -6F;
    		this.hard_head.rotationPointZ = -2.0F;
    		
    		this.armored_back_BL.rotateAngleX = 0.4641593F;
    		this.armored_back_BR.rotateAngleX = 0.4641593F;
    		this.armored_backneck.rotateAngleX = 0.15F;
    		this.armored_backTL.rotateAngleX = 0.15F;
    		this.armored_backTR.rotateAngleX = 0.15F;
    		
    		this.spike3L.rotateAngleX = -1.158997F;
    		this.spike3R.rotateAngleX = -1.158997F;
    		this.spike2L.rotateAngleX = -0.8547198F;
    		this.spike2R.rotateAngleX = -0.8547198F;
    		this.spike1R.rotateAngleX = -0.6353982F;
    		this.spike1L.rotateAngleX = -0.6353982F;
    		
    		this.bugwing_L.rotateAngleX = -0.4F;
    		this.bugwing_R.rotateAngleX = -0.4F;
    		this.bugwing_L.rotateAngleY = -0.9F;
    		this.bugwing_R.rotateAngleY = 0.9F;
    		this.bugwing_L.rotateAngleZ = -1.0F;
    		this.bugwing_R.rotateAngleZ = 1.0F;
    		
    		this.bugwing_L.rotationPointZ = 3;
    		this.bugwing_R.rotationPointZ = 3;
    		this.bugwing_L.rotationPointY = -5;
    		this.bugwing_R.rotationPointY = -5;
    		
    		this.jumper_leg1R.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.6F * f1 - 0.6235988F;
    		this.jumper_leg1L.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.6F * f1 - 0.6235988F;
    		this.jumper_leg2R.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.4F * f1  -0.2617994F + 0.8735988F;
    		this.jumper_leg2L.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.4F * f1  -0.2617994F + 0.8735988F;
    		
    		this.jumper_torso1.rotateAngleX = 0.06F;
    		
    		this.heavy_leg_1R.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.3F * f1 -0.4617994F;
    		this.heavy_leg_1L.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.3F * f1 -0.4617994F;
    		this.heavy_leg_2R.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.2F * f1 + 0.4617994F;
    		this.heavy_leg_2L.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.2F * f1 + 0.4617994F;
    		this.heavy_leg_2L.rotationPointY = -1.0F;
    		this.heavy_leg_2R.rotationPointY = -1.0F;
    		
    		this.crawler_torso2.rotationPointY = 7F;
    		this.crawler_torso2.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.2F * f1 - 0.5235988F;
    		this.lower_crawler_torso1.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.1F * f1 + 0.5235988F;
    		this.lower_crawler_torso2.rotateAngleX = -MathHelper.cos(f * 0.3662F) * 0.1F * f1 + 0.5235988F;
    		this.lower_crawler_torso3.rotateAngleX = -MathHelper.cos(f * 0.3662F) * 0.05F * f1 - 0.5235988F;
    		this.crawler_tail1.rotateAngleX = MathHelper.cos(f * 0.3662F+ (float)Math.PI) * 0.03F * f1 + 0.7853982F;
    		this.crawler_tail2.rotateAngleX = MathHelper.cos(f * 0.3662F+ (float)(3*Math.PI/2)) * 0.01F * f1 + 0.2617994F - 0.7853982F;
    		
    		this.crawler_torso1.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.2F * f1 + 0.1F;
    		this.crawler_leg5L.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)Math.PI) * 0.3F * f1 + 0.7853982F;
    		this.crawler_leg5R.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F) * 0.3F * f1 - 0.7853982F;
    		this.crawler_leg5L.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)Math.PI) * 0.3F * f1 - 0.7853982F;
    		this.crawler_leg5R.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F) * 0.3F * f1 + 0.7853982F;
    		this.crawler_leg4L.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)Math.PI + (float)(Math.PI/4)) * 0.3F * f1 + 0.7853982F;
    		this.crawler_leg4R.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)(Math.PI/4)) * 0.3F * f1 - 0.7853982F;
    		this.crawler_leg4L.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)Math.PI + (float)(Math.PI/4)) * 0.3F * f1;
    		this.crawler_leg4R.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)(Math.PI/4)) * 0.3F * f1;
    		this.crawler_leg3L.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)Math.PI + (float)(Math.PI/2)) * 0.3F * f1 + 0.7853982F;
    		this.crawler_leg3R.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)(Math.PI/2)) * 0.3F * f1 - 0.7853982F;
    		this.crawler_leg3L.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)Math.PI + (float)(Math.PI/2)) * 0.3F * f1;
    		this.crawler_leg3R.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)(Math.PI/2)) * 0.3F * f1;
    		this.crawler_leg2TL.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)Math.PI + (float)(3*Math.PI/4)) * 0.3F * f1 + 0.7853982F;
    		this.crawler_leg2TR.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)(3*Math.PI/4)) * 0.3F * f1 - 0.7853982F;
    		this.crawler_leg2TL.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)Math.PI + (float)(3*Math.PI/4)) * 0.3F * f1 +0.3490659F;
    		this.crawler_leg2TR.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)(3*Math.PI/4)) * 0.3F * f1 -0.3490659F;
        
    		this.wolf_tail_1.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) );
        	this.wolf_tail_2.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
        	this.wolf_tail_3.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
        	this.wolf_tail_4.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
        	this.wolf_tail_5.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
        	this.wolf_tail_6.rotateAngleZ = 0.05F*(MathHelper.cos(f2 * 0.06662F) ) ;
        	
        	this.wolf_tail_1.rotateAngleX = 1.034464F;
        	
        	this.shark_tail_1.rotateAngleY = 0.1F*(MathHelper.cos(f2 * 0.06662F));
			this.shark_tail_2.rotateAngleY = 0.1F*(MathHelper.cos(f2 * 0.06662F - (float)(Math.PI/6)));
			this.shark_tail_3.rotateAngleY = 0.1F*(MathHelper.cos(f2 * 0.06662F - (float)(Math.PI/3)));
			

			this.scorpion_tail1.rotationPointY = 8F;
			
			this.scorpion_tail1.rotateAngleX = 0.01F*(MathHelper.cos(f2 * 0.03662F));
			this.scorpion_tail2.rotateAngleX = 0.01F*(MathHelper.cos(f2 * 0.03662F - (float)(Math.PI/12)));
			this.scorpion_tail3.rotateAngleX = 0.01F*(MathHelper.cos(f2 * 0.03662F - (float)(Math.PI/6)));
			this.scorpion_tail4.rotateAngleX = 0.01F*(MathHelper.cos(f2 * 0.03662F - (float)(Math.PI/4)));
			this.scorpion_tail5.rotateAngleX = 0.01F*(MathHelper.cos(f2 * 0.03662F - (float)(Math.PI/3)));
			this.scorpion_tail6.rotateAngleX = 0.01F*(MathHelper.cos(f2 * 0.03662F - (float)(5*Math.PI/12)));
			this.scorpion_tail7.rotateAngleX = 0.01F*(MathHelper.cos(f2 * 0.03662F - (float)(Math.PI/2)));
			this.scorpion_tail8.rotateAngleX = 0.01F*(MathHelper.cos(f2 * 0.03662F - (float)(7*Math.PI/12)));
			this.scorpion_tail9.rotateAngleX = 0.01F*(MathHelper.cos(f2 * 0.03662F - (float)(2*Math.PI/3)));
			
    	}
    	else
    	{
    		this.default_torso.rotateAngleX = 0.3141593F;
    		this.Default_lowertorso.rotateAngleX = 0F;
    		this.default_tail1.rotateAngleX = -0.5235988F;
    		this.default_neck.rotateAngleX = 0.2617994F;
    		this.default_armL1.rotationPointY = -3.0F;
    		this.default_armR1.rotationPointY = -3.0F;
    		this.default_armL1.rotationPointZ = 1.0F;
    		this.default_armR1.rotationPointZ = 1.0F;
    		this.default_head.rotationPointY = -7.5F;
    		this.default_head.rotationPointZ = 0.0F;
    		this.default_wing_stubR.rotationPointY = -3.0F;
    		this.default_wing_stubL.rotationPointY = -3.0F;
    		this.default_wing_stubR.rotationPointZ = 4.0F;
    		this.default_wing_stubL.rotationPointZ = 4.0F;
    		this.default_legR1.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.6F * f1 -0.5235988F;
    		this.default_legL1.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.6F * f1 -0.5235988F;   	
    		this.default_legR2.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.3F * f1 + 0.2617994F + 0.5235988F;
    		this.default_legL2.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.3F * f1 + 0.2617994F + 0.5235988F;
    		this.default_legL2.rotationPointZ = 0.0F;
    		this.default_legR2.rotationPointZ = 0.0F;
    		
    		this.spitter_head.rotationPointY = -7F;
    		this.spitter_head.rotationPointZ = 0F;

    		this.hornhead_1.rotationPointY = -7F;
    		this.hornhead_1.rotationPointZ = 0F;
    		
    		this.hard_head.rotationPointY = -7F;
    		this.hard_head.rotationPointZ = 0F;
    		
    		this.armored_back_BL.rotateAngleX = 0.3141593F;
    		this.armored_back_BR.rotateAngleX = 0.3141593F;
    		this.armored_backneck.rotateAngleX = 0;
    		this.armored_backTL.rotateAngleX = 0;
    		this.armored_backTR.rotateAngleX = 0;
    		
    		this.spike3L.rotateAngleX = -1.308997F;
    		this.spike3R.rotateAngleX = -1.308997F;
    		this.spike2L.rotateAngleX = -1.047198F;
    		this.spike2R.rotateAngleX = -1.047198F;
    		this.spike1R.rotateAngleX = -0.7853982F;
    		this.spike1L.rotateAngleX = -0.7853982F;
    		if(!player.onGround && !player.isInWater())
    		{

    	    	this.bugwing_L.rotateAngleX = 0.4F*(MathHelper.cos(f2 * 2.0F * 0.66662F) ) + 0.7853982F;
    			this.bugwing_R.rotateAngleX = 0.4F*(MathHelper.cos(f2 * 2.0F * 0.66662F) ) + 0.7853982F;
    			this.bugwing_L.rotateAngleY = -0.4F*(MathHelper.cos(f2 * 2.0F * 0.66662F) ) +0.5235988F;
    			this.bugwing_R.rotateAngleY = 0.4F*(MathHelper.cos(f2 * 2.0F * 0.66662F) ) -0.5235988F;
    			this.bugwing_L.rotateAngleZ = -0.3F*(MathHelper.cos(f2 * 2.0F * 0.66662F - (float)(3 *Math.PI/2)));
    			this.bugwing_R.rotateAngleZ = 0.3F*(MathHelper.cos(f2 * 2.0F * 0.66662F - (float)(3 *Math.PI/2)));
    			

    		}
    		else
    		{
    			this.bugwing_L.rotateAngleX = 0.2F*(MathHelper.cos(f2 * 0.06662F) ) + 0.7853982F;
    			this.bugwing_R.rotateAngleX = 0.2F*(MathHelper.cos(f2 * 0.06662F) ) + 0.7853982F;
    			this.bugwing_L.rotateAngleY = -0.2F*(MathHelper.cos(f2 * 0.06662F) ) +0.5235988F;
    			this.bugwing_R.rotateAngleY = 0.2F*(MathHelper.cos(f2 * 0.06662F) ) -0.5235988F;
    			this.bugwing_L.rotateAngleZ = -0.2F*(MathHelper.cos(f2 * 0.06662F - (float)(3 *Math.PI/2)));
    			this.bugwing_R.rotateAngleZ = 0.2F*(MathHelper.cos(f2 * 0.06662F - (float)(3 *Math.PI/2)));
    		
    		}
    		this.bugwing_L.rotationPointZ = 5;
    		this.bugwing_R.rotationPointZ = 5;
    		this.bugwing_L.rotationPointY = -3;
    		this.bugwing_R.rotationPointY = -3;
    		
    		this.jumper_leg1R.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.6F * f1 - 0.5235988F;
    		this.jumper_leg1L.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.6F * f1 - 0.5235988F;
    		this.jumper_leg2R.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.4F * f1  -0.2617994F + 0.5235988F;
    		this.jumper_leg2L.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.4F * f1  -0.2617994F + 0.5235988F;
    		this.jumper_torso1.rotateAngleX = 0F;
    		
    		this.heavy_leg_1R.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.3F * f1 -0.2617994F;
    		this.heavy_leg_1L.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.3F * f1 -0.2617994F;
    		this.heavy_leg_2R.rotateAngleX = MathHelper.cos(f * 0.3662F + (float)Math.PI) * 0.2F * f1  + 0.2617994F;
    		this.heavy_leg_2L.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.2F * f1 + 0.2617994F;
    		this.heavy_leg_2L.rotationPointY = 0.0F;
    		this.heavy_leg_2R.rotationPointY = 0.0F;

    		this.crawler_torso2.rotationPointY = 9F;
    		this.crawler_torso2.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.2F * f1 - 0.5235988F;
    		this.lower_crawler_torso1.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.1F * f1 + 0.5235988F;
    		this.lower_crawler_torso2.rotateAngleX = -MathHelper.cos(f * 0.3662F) * 0.1F * f1 + 0.5235988F;
    		this.lower_crawler_torso3.rotateAngleX = -MathHelper.cos(f * 0.3662F) * 0.05F * f1 - 0.5235988F;
    		this.crawler_tail1.rotateAngleX = MathHelper.cos(f * 0.3662F+ (float)Math.PI) * 0.03F * f1 + 0.7853982F;
    		this.crawler_tail2.rotateAngleX = MathHelper.cos(f * 0.3662F+ (float)(3*Math.PI/2)) * 0.01F * f1 + 0.2617994F - 0.7853982F;
    		this.crawler_torso1.rotateAngleX = MathHelper.cos(f * 0.3662F) * 0.1F * f1;
    		
    		this.crawler_leg5L.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)Math.PI) * 0.3F * f1 + 0.7853982F;
    		this.crawler_leg5R.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F) * 0.3F * f1 - 0.7853982F;
    		this.crawler_leg5L.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)Math.PI) * 0.3F * f1 - 0.7853982F;
    		this.crawler_leg5R.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F) * 0.3F * f1 + 0.7853982F;
    		this.crawler_leg4L.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)Math.PI + (float)(Math.PI/4)) * 0.3F * f1 + 0.7853982F;
    		this.crawler_leg4R.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)(Math.PI/4)) * 0.3F * f1 - 0.7853982F;
    		this.crawler_leg4L.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)Math.PI + (float)(Math.PI/4)) * 0.3F * f1;
    		this.crawler_leg4R.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)(Math.PI/4)) * 0.3F * f1;
    		this.crawler_leg3L.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)Math.PI + (float)(Math.PI/2)) * 0.3F * f1 + 0.7853982F;
    		this.crawler_leg3R.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)(Math.PI/2)) * 0.3F * f1 - 0.7853982F;
    		this.crawler_leg3L.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)Math.PI + (float)(Math.PI/2)) * 0.3F * f1;
    		this.crawler_leg3R.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)(Math.PI/2)) * 0.3F * f1;
    		this.crawler_leg2TL.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)Math.PI + (float)(3*Math.PI/4)) * 0.3F * f1 + 0.7853982F;
    		this.crawler_leg2TR.rotateAngleZ = MathHelper.sin(f * 2.0F * 0.3662F + (float)(3*Math.PI/4)) * 0.3F * f1 - 0.7853982F;
    		this.crawler_leg2TL.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)Math.PI + (float)(3*Math.PI/4)) * 0.3F * f1 +0.3490659F;
    		this.crawler_leg2TR.rotateAngleY = MathHelper.cos(f * 2.0F * 0.3662F + (float)(3*Math.PI/4)) * 0.3F * f1 -0.3490659F;
    	    
    		
    		this.shark_tail_1.rotateAngleY = 0.15F*(MathHelper.cos(f2 * 0.16662F));
			this.shark_tail_2.rotateAngleY = 0.15F*(MathHelper.cos(f2 * 0.16662F - (float)(Math.PI/6)));
			this.shark_tail_3.rotateAngleY = 0.15F*(MathHelper.cos(f2 * 0.16662F - (float)(Math.PI/3)));
		
			this.scorpion_tail1.rotationPointY = 9F;
			
			this.scorpion_tail1.rotateAngleX = 0.02F*(MathHelper.cos(f2 * 0.06662F));
			this.scorpion_tail2.rotateAngleX = 0.02F*(MathHelper.cos(f2 * 0.06662F - (float)(Math.PI/12)));
			this.scorpion_tail3.rotateAngleX = 0.02F*(MathHelper.cos(f2 * 0.06662F - (float)(Math.PI/6)));
			this.scorpion_tail4.rotateAngleX = 0.02F*(MathHelper.cos(f2 * 0.06662F - (float)(Math.PI/4)));
			this.scorpion_tail5.rotateAngleX = 0.02F*(MathHelper.cos(f2 * 0.06662F - (float)(Math.PI/3)));
			this.scorpion_tail6.rotateAngleX = 0.02F*(MathHelper.cos(f2 * 0.06662F - (float)(5*Math.PI/12)));
			this.scorpion_tail7.rotateAngleX = 0.02F*(MathHelper.cos(f2 * 0.06662F - (float)(Math.PI/2)));
			this.scorpion_tail8.rotateAngleX = 0.02F*(MathHelper.cos(f2 * 0.06662F - (float)(7*Math.PI/12)));
			this.scorpion_tail9.rotateAngleX = 0.02F*(MathHelper.cos(f2 * 0.06662F - (float)(2*Math.PI/3)));
		
    	}
    	
    	if (player.getHeldItem() != null)
        {
            this.default_armR1.rotateAngleY = this.bipedRightArm.rotateAngleY;
        }
    	
    	if((player.worldObj.getBlock((int)player.posX, (int)player.posY, (int)player.posZ) == Blocks.water || player.worldObj.getBlock((int)player.posX, (int)player.posY - 1, (int)player.posZ) == Blocks.water) && (Math.abs(player.motionX) > 0 || Math.abs(player.motionZ) > 0))
    	{
    		this.shark_tail_1.rotateAngleY = 0.25F*(MathHelper.cos(f2 * (0.36662F)));
			this.shark_tail_2.rotateAngleY = 0.25F*(MathHelper.cos(f2 * (0.36662F) - (float)(Math.PI/6)));
			this.shark_tail_3.rotateAngleY = 0.25F*(MathHelper.cos(f2 * (0.36662F) - (float)(Math.PI/3)));
		
    	}
    }    
  }

}
