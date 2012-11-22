package de.adorsys.erraihtml5;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;

import de.adorsys.errai.example.api.Person;

@Singleton
@Templated
public class PersonList extends Composite {

	static PersonRow PERSON_ROW_TEMPLATE = GWT.create(PersonRow.class);
//	private static PersonListUiBinder UI_BINDER = GWT.create(PersonListUiBinder.class);
//	@UiField
	
	@DataField
	CellTable<Person> personsTable = new CellTable<Person>();
	
	private List<Person> persons = new ArrayList<Person>();
	
//	interface PersonListUiBinder extends UiBinder<Widget, PersonList>{
//	}
	
	public PersonList() {
//		initWidget(UI_BINDER.createAndBindUi(this));
		initPersonTable(persons);
	}	
	public void initPersonTable(List<Person> persons) {
		int columnCount = personsTable.getColumnCount();
		 for (int i = 0; i < columnCount; i++) {
			personsTable.removeColumn(0);
		}
		personsTable.addColumn(new TextColumn<Person>() {

			@Override
			public String getValue(Person person) {
				return person.getFirstName();
			}
		}, "First Name");
		personsTable.addColumn(new TextColumn<Person>() {

			@Override
			public String getValue(Person person) {
				return person.getSureName();
			}
		}, "Sure Name");
		personsTable.addColumn(new TextColumn<Person>() {

			@Override
			public String getValue(Person person) {
				return person.getAddress().getCity();
			}
		}, "City");
		final NoSelectionModel<Person> selectionModel = new NoSelectionModel<Person>();
		selectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

					@Override
					public void onSelectionChange(SelectionChangeEvent event) {
						Person person = selectionModel.getLastSelectedObject();
						System.out.println("Selected Person  " + person);
					}
				});
		personsTable.setRowData(persons);
	}

	public interface PersonRow extends SafeHtmlTemplates {
		@Template("<tr> <td>{0}</td> <td>{1}</td> <td>{2}</td> <td>{3}</td> <td>{4}</td> <td>{5}</td></tr>")
		SafeHtml getRow(int rank, String firstName, String sureName,
				String street, String postCode, String city);
	}

	public String buildPersonTableRows(List<Person> persons) {
		StringBuilder builder = new StringBuilder();

		int i = 0;
		for (Person person : persons) {
			SafeHtml row = PERSON_ROW_TEMPLATE.getRow(i, person.getFirstName(),
					person.getSureName(), person.getAddress().getStreet(),
					person.getAddress().getPostcode(), person.getAddress()
							.getCity());
			builder.append(row.asString());
			i++;
		}
		System.out.println(builder.toString());
		return builder.toString();
	}

	/**
	 * @return the persons
	 */
	public List<Person> getPersons() {
		return persons;
	}

	/**
	 * @param persons
	 *            the persons to set
	 */
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}