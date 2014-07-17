package com.example.jenkinsprototype;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Deck extends Activity {

	/**
	 * An array of 52 or 54 cards.  A 54-card deck contains two Jokers,
	 * in addition to the 52 cards of a regular poker deck.
	 */
	public Card[] deck;
	private Button buttonShuffle;
	private TextView textOutput;
    public String output;
	

	/**
	 * Constructs a poker deck of plaing cards, The deck contains
	 * the ususal 52 cards and can optionally contain two Jokers
	 * in addtion, for a total of 54 cards.    Initially the cards
	 * are in a sorted order.  The shuffle() method can be called to
	 * randomize the order.
	 * includeJokers if true, two Jokers are included in the deck.
	 */
	public Deck() {
		
			
		
	}
    //changes
//some update
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.root_layout);
		
		deck = new Card[54];
		int cardCt = 0; // How many cards have been created so far.
		for ( int suit = 0; suit <= 3; suit++ ) {
			for ( int value = 1; value <= 13; value++ ) {
				deck[cardCt] = new Card(value,suit);
				cardCt++;
			}
		}
		
			deck[52] = new Card(1,Card.JOKER);
			deck[53] = new Card(2,Card.JOKER);
         initLayout();
	}


	private void initLayout() {
		// TODO Auto-generated method stub
		textOutput=(TextView)findViewById(R.id.textOutput);
		buttonShuffle=(Button)findViewById(R.id.buttonShuffle);
		
		buttonShuffle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                textOutput.setText(" ");
				shuffle();
				outputDisplay();
			}
		});
		
		
	}

	protected void outputDisplay() {
		// TODO Auto-generated method stub
	StringBuilder str=new StringBuilder();
		for(int i=0;i<deck.length;i++)
		{
			Card temp = deck[i];
			str.append(temp.toString());
			str.append("," + " ");
		}
        str.deleteCharAt(str.lastIndexOf(","));
		textOutput.setText(str.toString());

		output=textOutput.toString();
      //  output.replace(/^,|,$/g, '');

	}

	/**
	 * shuffle the deck into a random order.
	 */
	public void shuffle() {
		for ( int i = deck.length-1; i > 0; i-- ) {
			int rand = (int)(Math.random()*(i+1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
	
	}

}
