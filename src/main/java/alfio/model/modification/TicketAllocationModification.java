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
package alfio.model.modification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TicketAllocationModification {
    private final int srcCategoryId;
    private final int targetCategoryId;
    private final int eventId;

    @JsonCreator
    public TicketAllocationModification(@JsonProperty("srcCategoryId") int srcCategoryId,
                                        @JsonProperty("targetCategoryId") int targetCategoryId,
                                        @JsonProperty("eventId") int eventId) {
        this.srcCategoryId = srcCategoryId;
        this.targetCategoryId = targetCategoryId;
        this.eventId = eventId;
    }
}
