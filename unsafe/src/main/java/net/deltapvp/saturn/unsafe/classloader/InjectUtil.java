/*
 * This file is part of Saturn, licensed under the MIT License.
 *
 *  Copyright (c) 2022 powercas_gamer
 *  Copyright (c) 2022 contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.deltapvp.saturn.unsafe.classloader;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;

/**
 * @author <a href="https://github.com/Laarryy/Anti-VPN/blob/v6-j17/Common/src/main/java/me/egg82/antivpn/dependencies/InjectUtil.java">...</a>
 */
public final class InjectUtil {
    private InjectUtil() {
    }

    /**
     *
     * @param file the file to inject
     * @param loader the loader which to include the jar to
     * @throws IOException if the file does not exist or is not a file
     */
    public static void injectFile(@NotNull final File file, @NotNull final URLClassLoader loader) throws IOException {

        if (file.exists() && file.isDirectory()) {
            throw new IOException("file is not a file.");
        }
        if (!file.exists()) {
            throw new IOException("file does not exist.");
        }

        URLClassLoaderAccess.create(loader).addURL(file.toURI().toURL());
    }
}
