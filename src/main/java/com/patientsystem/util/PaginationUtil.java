package com.patientsystem.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Component
public class PaginationUtil
{
	public static final String DELIMITER = ",";
	public static char DESC_CHAR = '-';

	private enum MyDirection
	{
		ASC
				{
					@Override
					public Sort.Order createOrder( String property )
					{
						return Sort.Order.asc( property )
										 .ignoreCase();
					}
				},
		DESC
				{
					@Override
					public Sort.Order createOrder( String property )
					{
						return Sort.Order.desc( property )
										 .ignoreCase();
					}
				};

		public abstract Sort.Order createOrder( String property );
	}

	private static class SortOrder
	{
		private final String property;
		private final MyDirection direction;

		public SortOrder( String token )
		{
			if ( token.charAt( 0 ) == DESC_CHAR )
			{
				direction = MyDirection.DESC;
				property = token.substring( 1 );
			}
			else
			{
				direction = MyDirection.ASC;
				property = token;
			}
		}

		public Sort.Order getOrder()
		{
			return direction.createOrder( property );
		}
	}

	// equivalent of getSortTokens(..)
	// but parallel
	private List<Sort.Order> getSortTokensWithJava8( String sortby )
	{
		return Collections.list( new StringTokenizer( sortby, DELIMITER ) )
						  .stream()
						  .parallel()
						  .map( token -> new SortOrder( ( String ) token ) )
						  .map( SortOrder::getOrder )
						  .collect( Collectors.toList() );
	}

	private List<Sort.Order> getSortTokens( String sortby )
	{
		StringTokenizer stringTokenizer = new StringTokenizer( sortby, DELIMITER );
		List<Sort.Order> orders = new ArrayList<>();
		while ( stringTokenizer.hasMoreTokens() )
		{
			SortOrder sortOrder = new SortOrder( stringTokenizer.nextToken() );
			orders.add( sortOrder.getOrder() );
		}
		return orders;
	}

	public Pageable createPageable( int page, int size, String sortby )
	{
		return PageRequest.of( page, size, Sort.by( getSortTokens( sortby ) ) );
	}
}
