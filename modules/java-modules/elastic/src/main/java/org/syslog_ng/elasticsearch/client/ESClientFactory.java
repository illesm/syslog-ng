/*
 * Copyright (c) 2015 Balabit
 * Copyright (c) 2015 Viktor Juhasz <viktor.juhasz@balabit.com>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * As an additional exemption you are allowed to compile & link against the
 * OpenSSL libraries as published by the OpenSSL project. See the file
 * COPYING for details.
 *
 */

package org.syslog_ng.elasticsearch.client;

import org.syslog_ng.elasticsearch.ElasticSearchOptions;

public class ESClientFactory {
	public static ESClient getESClient(ElasticSearchOptions options) throws UnknownESClientModeException {
		String client_type = options.getClientMode();
		if (client_type.equals(ElasticSearchOptions.CLIENT_MODE_TRANSPORT)|| client_type.equals(ElasticSearchOptions.CLIENT_MODE_SHIELD)) {
			return new ESTransportClient(options);
		}
		else if (client_type.equals(ElasticSearchOptions.CLIENT_MODE_NODE)) {
			return new ESNodeClient(options);
		}
		throw new UnknownESClientModeException(client_type);
	}
}
