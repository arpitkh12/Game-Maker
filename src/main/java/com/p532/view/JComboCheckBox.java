package com.p532.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.p532.constants.Constants;

@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
public class JComboCheckBox extends JComboBox implements Constants {
	private static ArrayList<Integer> checkBoxes = new ArrayList<Integer>();
	private static Vector allActionsList;
	private SpritePanel spritePanel;

	public JComboCheckBox() {
		init();
	}

	public JComboCheckBox(JCheckBox[] items) {
		super(items);
		init();
	}

	public JComboCheckBox(Vector items, SpritePanel spritePanel) {
		super(items);
		JComboCheckBox.allActionsList = items;
		this.spritePanel = spritePanel;
		init();
	}

	public JComboCheckBox(ComboBoxModel aModel) {
		super(aModel);
		init();
	}

	private void init() {
		setRenderer(new ComboBoxRenderer());
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				itemSelected();
			}
		});
	}

	private void itemSelected() {
		if (getSelectedItem() instanceof JCheckBox) {
			JCheckBox jcb = (JCheckBox) getSelectedItem();
			jcb.setSelected(!jcb.isSelected());
			if (jcb.isSelected()) {
				String str = ((JCheckBox) getSelectedItem()).getText();
				int index;
				// if item is selected, compare that item to the item in ACTIONS
				// list
				// and add it's index to returnedList: checkBoxes in
				// getSelected()

				for (int i = 0; i < ACTIONS.length; i++) {
					if (str.equalsIgnoreCase(ACTIONS[i])) {
						index = i;
						checkBoxes.add(index);
					} else {
						index = i;
						if (!jcb.isSelected())
							checkBoxes.remove(index);
					}

				}
			}

		}
	}

	public ArrayList<Integer> getSelected() {
		itemSelected();
		ArrayList<Integer> check = new ArrayList<Integer>(checkBoxes);
		checkBoxes.clear();
		for (int i = 0; i < allActionsList.size(); i++) {
			allActionsList.setElementAt(new JCheckBox(ACTIONS[i], false), i);
		}
		spritePanel.setAllActionsList(allActionsList);
		return check;

	}

	public static void clear() {
		checkBoxes.clear();
		for (int i = 0; i < allActionsList.size(); i++) {
			allActionsList.setElementAt(new JCheckBox(ACTIONS[i], false), i);
		}

	}

	class ComboBoxRenderer implements ListCellRenderer {
		private JLabel label;

		public ComboBoxRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			if (value instanceof Component) {
				Component c = (Component) value;
				if (isSelected) {
					c.setBackground(list.getSelectionBackground());
					c.setForeground(list.getSelectionForeground());
				} else {
					c.setBackground(list.getBackground());
					c.setForeground(list.getForeground());
				}

				return c;
			} else {
				if (label == null) {
					label = new JLabel(value.toString());
				} else {
					label.setText(value.toString());
				}

				return label;
			}
		}
	}
}