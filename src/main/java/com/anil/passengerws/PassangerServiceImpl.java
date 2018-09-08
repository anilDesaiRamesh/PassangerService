/**
 * 
 */
package com.anil.passengerws;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.anil.passengerws.exception.PassangerNotFoundException;
import com.anil.passengerws.exception.invalidAgentException;
import com.anil.passengerws.model.Passanger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Anil_Ramesh
 *
 */
@Service
public class PassangerServiceImpl implements IPassangerService {

	List<Passanger> passangers = new ArrayList();

	public PassangerServiceImpl() {
		super();
		System.out.println("inside constructor");
		init();
		// TODO Auto-generated constructor stub
	}

	private void init() {
		// TODO Auto-generated method stub
		Passanger passanger = new Passanger(currentId, "Cena");
		passangers.add(passanger);
	}

	int currentId = 123;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anil.passengerws.IPassangerService#getPassanger()
	 */
	@Override
	public List<Passanger> getPassanger(int start, int size) throws JsonProcessingException {
		// TODO Auto-generated method stub
		System.out.println("inside getPassanger " + start + "  " + size);

		// Use below line if returning list does not work
		// return new ObjectMapper().writeValueAsString(passangers);
		return passangers;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anil.passengerws.IPassangerService#addPassanger()
	 */
	@Override
	public Passanger addPassanger(Passanger passanger) {
		// TODO Auto-generated method stub

		passanger.setId(++currentId);
		passangers.add(passanger);
		return passanger;
	}

	@Override
	public Response getPassangerByid(int id) {
		// TODO Auto-generated method stub
		System.out.println("id " + id);
		System.out.println("passangers.contains(id) " + passangers.contains(id));
		Passanger passanger = new Passanger();
		Iterator iterator = passangers.iterator();
		boolean flag = false;
		while (iterator.hasNext()) {
			passanger = (Passanger) iterator.next();
			if (passanger.getId() == id) {
				flag = true;
				break;
			} else
				flag = false;
		}

		if (flag)
			return Response.ok(passanger).build();
		else
			throw new PassangerNotFoundException();
	}

	@Override
	public Response addPassanger(String firstName, String lastName, String agent, HttpHeaders httpHeaders) {
		// TODO Auto-generated method stub
		// System.out.println("httpHeaders " + httpHeaders);
		MultivaluedMap<String, String> requestHeaders = httpHeaders.getRequestHeaders();
		Set<String> keySet = requestHeaders.keySet();
		System.out.println("------------------------");
		System.out.println("Header");
		System.out.println("------------------------");
		for (String key : keySet) {
			System.out.println("keySet " + httpHeaders.getHeaderString(key));
		}
		System.out.println("------------------------");
		System.out.println("Cookie");
		System.out.println("------------------------");
		Map<String, Cookie> cookies = httpHeaders.getCookies();
		Set<String> keySet2 = cookies.keySet();
		for(String key1 : keySet2) {
			System.out.println(cookies.get(key1).getValue());
		}
		if (agent.trim().equalsIgnoreCase("British Airways")) {
			String stName = firstName + "  " + lastName;
			Passanger passanger = new Passanger(++currentId, stName);
			passangers.add(passanger);
			return Response.ok(passanger).build();
		} else
			throw new invalidAgentException();

	}

}
