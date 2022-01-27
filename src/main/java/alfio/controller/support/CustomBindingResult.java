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
package alfio.controller.support;

import lombok.experimental.Delegate;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class CustomBindingResult implements BindingResult {
    @Delegate
    private final BindingResult target;
    private final List<String> warningCodes = new ArrayList<>();

    public CustomBindingResult(BindingResult target) {
        this.target = target;
    }

    public void addWarning(String code) {
        this.warningCodes.add(code);
    }

    public List<String> getWarningCodes() {
        return warningCodes;
    }

    public boolean hasWarnings() {
        return !warningCodes.isEmpty();
    }
}
