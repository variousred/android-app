/*
 *                 [[ Frozen-Bubble ]]
 *
 * Copyright (c) 2000-2003 Guillaume Cottenceau.
 * Java sourcecode - Copyright (c) 2003 Glenn Sanson.
 *
 * This code is distributed under the GNU General Public License
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 *
 * Artwork:
 *    Alexis Younes <73lab at free.fr>
 *      (everything but the bubbles)
 *    Amaury Amblard-Ladurantie <amaury at linuxfr.org>
 *      (the bubbles)
 *
 * Soundtrack:
 *    Matthias Le Bidan <matthias.le_bidan at caramail.com>
 *      (the three musics and all the sound effects)
 *
 * Design & Programming:
 *    Guillaume Cottenceau <guillaume.cottenceau at free.fr>
 *      (design and manage the project, whole Perl sourcecode)
 *
 * Java version:
 *    Glenn Sanson <glenn.sanson at free.fr>
 *      (whole Java sourcecode, including JIGA classes
 *             http://glenn.sanson.free.fr/jiga/)
 *
 * Android port:
 *    Pawel Aleksander Fedorynski <pfedor@fuw.edu.pl>
 *    Copyright (c) Google Inc.
 *
 *          [[ http://glenn.sanson.free.fr/fb/ ]]
 *          [[ http://www.frozen-bubble.org/   ]]
 */

package org.jfedor.frozenbubble;

import java.util.Random;
import android.os.Bundle;

/**
 * Class BubbleManager.
 * 
 */
public class BubbleManager {
	int bubblesLeft;
	BmpWrap[] bubbles;
	int[] countBubbles;

	/**
	 * Initialize BubbleManager.
	 * 
	 * @param bubbles
	 *            BmpWrp[]
	 */
	public BubbleManager(BmpWrap[] bubbles) {
		this.bubbles = bubbles;
		this.countBubbles = new int[bubbles.length];
		this.bubblesLeft = 0;
	}

	/**
	 * Save state.
	 * 
	 * @param map
	 *            Bundle
	 */
	public void saveState(Bundle map) {
		map.putInt("BubbleManager-bubblesLeft", bubblesLeft);
		map.putIntArray("BubbleManager-countBubbles", countBubbles);
	}

	/**
	 * Restore state.
	 * 
	 * @param map
	 *            Bundle
	 */
	public void restoreState(Bundle map) {
		bubblesLeft = map.getInt("BubbleManager-bubblesLeft");
		countBubbles = map.getIntArray("BubbleManager-countBubbles");
	}

	/**
	 * Add bubble.
	 * 
	 * @param bubble
	 *            BmpWrap
	 */
	public void addBubble(BmpWrap bubble) {
		countBubbles[findBubble(bubble)]++;
		bubblesLeft++;
	}

	/**
	 * Remove bubble.
	 * 
	 * @param bubble
	 *            BmpWrap
	 */
	public void removeBubble(BmpWrap bubble) {
		countBubbles[findBubble(bubble)]--;
		bubblesLeft--;
	}

	/**
	 * Count bubbles.
	 * 
	 * @return int bubble count
	 */
	public int countBubbles() {
		return bubblesLeft;
	}

	/**
	 * Get next bubble index.
	 * 
	 * @param rand
	 *            Random
	 * @return int index
	 */
	public int nextBubbleIndex(Random rand) {
		int select = rand.nextInt() % bubbles.length;

		if (select < 0) {
			select = -select;
		}

		int count = -1;
		int position = -1;

		while (count != select) {
			position++;

			if (position == bubbles.length) {
				position = 0;
			}

			if (countBubbles[position] != 0) {
				count++;
			}
		}

		return position;
	}

	/**
	 * Get next bubble.
	 * 
	 * @param rand
	 *            Random
	 * @return BmpWrp next bubble
	 */
	public BmpWrap nextBubble(Random rand) {
		return bubbles[nextBubbleIndex(rand)];
	}

	/**
	 * Private find bubble.
	 * 
	 * @param bubble
	 *            BmpWrap
	 * @return int index of bubble or -1 if not found
	 */
	private int findBubble(BmpWrap bubble) {
		for (int i = 0; i < bubbles.length; i++) {
			if (bubbles[i] == bubble) {
				return i;
			}
		}

		return -1;
	}
}
