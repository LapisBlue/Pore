/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package blue.lapis.pore.impl;

import blue.lapis.pore.Pore;

import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.user.UserStorageService;
import org.spongepowered.api.util.ban.Ban;

import java.util.Collection;
import java.util.Optional;

public final class PoreUserBanList extends PoreBanList<Ban.Profile> {

    @Override
    protected Optional<Ban.Profile> getBanFor(String target) {
        return getGameProfile(target).flatMap(getBanService()::getBanFor);
    }

    @Override
    protected boolean setTarget(Ban.Builder builder, String target) {
        Optional<GameProfile> profile = getGameProfile(target);
        if (!profile.isPresent()) {
            return false;
        }
        builder.profile(profile.get());
        return true;
    }

    @Override
    protected Collection<Ban.Profile> getBans() {
        return getBanService().getProfileBans();
    }

    @Override
    protected String getTarget(Ban.Profile ban) {
        return ban.getProfile().getName().get();
    }

    @Override
    public void pardon(String target) {
        getGameProfile(target).ifPresent(getBanService()::pardon);
    }

    private Optional<GameProfile> getGameProfile(String target) {
        return Pore.getGame().getServiceManager().provideUnchecked(UserStorageService.class).get(target)
                .map(User::getProfile);
    }
}
