package io.anuke.mindustry.ui.fragments;

import io.anuke.mindustry.graphics.Palette;
import io.anuke.arc.scene.Group;
import io.anuke.arc.scene.event.Touchable;
import io.anuke.arc.scene.ui.Label;
import io.anuke.arc.scene.ui.TextButton;
import io.anuke.arc.scene.ui.layout.Table;

public class LoadingFragment extends Fragment{
    private Table table;
    private TextButton button;

    @Override
    public void build(Group parent){
        parent.fill("loadDim", t -> {
            t.visible(false);
            t.touchable(Touchable.enabled);
            t.add().height(70f).row();

            t.addImage("white").growX().height(3f).pad(4f).growX().get().setColor(Palette.accent);
            t.row();
            t.add("$text.loading").name("namelabel").pad(10f);
            t.row();
            t.addImage("white").growX().height(3f).pad(4f).growX().get().setColor(Palette.accent);
            t.row();

            button = t.addButton("$text.cancel", () -> {}).pad(20).size(250f, 70f).visible(false).get();
            table = t;
        });
    }

    public void setButton(Runnable listener){
        button.visible(true);
        button.getListeners().removeAt(button.getListeners().size - 1);
        button.clicked(listener);
    }

    public void show(){
        show("$text.loading");
    }

    public void show(String text){
        table.<Label>find("namelabel").setText(text);
        table.visible(true);
        table.toFront();
    }

    public void hide(){
        table.visible(false);
        button.visible(false);
    }
}
