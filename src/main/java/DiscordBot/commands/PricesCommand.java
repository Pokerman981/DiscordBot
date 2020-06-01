package DiscordBot.commands;

import DiscordBot.main;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class PricesCommand extends Command {
    public PricesCommand(){
        this.name = "prices";
        this.category = main.NORMAL;
        this.help = "Displays links to the price list of each server";
    }

    @Override
    protected void execute(CommandEvent event) {
        EmbedBuilder pokedash = new EmbedBuilder();
        pokedash.setTitle("Minimum Prices").setColor(Color.green)
//                .setThumbnail("https://i.gyazo.com/13255ea852d4551df36e9c1c9c3d4e92.png")
                .getDescriptionBuilder()
                .append("<:pokedash:375433829764169741> **PokeDash** <:pokedash:375433829764169741> https://pxl.plus/pdprices" +
                        "\n<:pokeverse:526264631744790549> **Pokeverse** <:pokeverse:526264631744790549> https://pxl.plus/pvprices" +
                        "\n<:pokelegends:628381164939247636> **PokeLegends** <:pokelegends:628381164939247636> https://pxl.plus/plprices " +
                        "\n<:pokeclub:526264234716299284> **PokeClub** <:pokeclub:526264234716299284> https://pxl.plus/pcprices" +
                        "\n<:pokebrawl:586480683397152820> **PokeBrawl** <:pokebrawl:586480683397152820> https://pxl.plus/pbprices");

        event.reply(pokedash.build());
    }
}