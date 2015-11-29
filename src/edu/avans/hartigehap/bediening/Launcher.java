/*
 * Copyright (C) 2015, David Verhaak
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.avans.hartigehap.bediening;


import edu.avans.hartigehap.bediening.logic.OrderManager;
import edu.avans.hartigehap.bediening.ui.SummaryGUI;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author David Verhaak
 * @version 1.0.0
 */
public class Launcher
{

	public static void main(String[] args)
	{
		final OrderManager manager = OrderManager.getInstance();
		Timer timer = new Timer();
		timer.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				manager.refresh();
			}
		}, 0, 5000);
		new SummaryGUI().setVisible(true);
	}
}