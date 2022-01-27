/**
 * This file is part of alf.io.
 *
 * alf.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alf.io is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with alf.io.  If not, see <http://www.gnu.org/licenses/>.
 */
package alfio.manager.payment.saferpay;

import com.google.gson.stream.JsonWriter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.StringWriter;

@RequiredArgsConstructor
public class TransactionRefundBuilder {
    private final String captureId;
    private final int retryIndicator;
    private String customerId;
    private String requestId;

    public TransactionRefundBuilder addAuthentication(String customerId, String requestId) {
        this.customerId = customerId;
        this.requestId = requestId;
        return this;
    }

    // @formatter:off
    @SneakyThrows
    public String build(String amountToRefund, String currencyCode) {
        var out = new StringWriter();
        var requestHeaderBuilder = new RequestHeaderBuilder(customerId, requestId, retryIndicator);
        try (var writer = new JsonWriter(out)) {
            requestHeaderBuilder.appendTo(writer.beginObject())
                .name("Refund").beginObject()
                    .name("Amount").beginObject()
                        .name("Value").value(amountToRefund)
                        .name("CurrencyCode").value(currencyCode)
                    .endObject()
                .endObject()
                .name("CaptureReference").beginObject()
                    .name("CaptureId").value(captureId)
                .endObject()
            .endObject().flush();
        }
        return out.toString();
    }
    // @formatter:on
}
